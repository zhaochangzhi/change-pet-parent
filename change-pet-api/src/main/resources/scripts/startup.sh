#!/bin/bash
source /etc/profile

OPERATE=$1
APP_TYPE="java"
APP_PATH="${appPath}"
ARGS=" ${start-class} "
APP_FULL_PATH="___________________"

RUNNING="false"
START_LIMIT=1
STOP_LIMIT=2


# 处理相对路径
if [ ${APP_PATH:0:1} != "/" ]; then
	APP_PATH="$(pwd)/${APP_PATH}"
fi
# 创建log目录
mkdir  -p ${APP_PATH}/{log,bin}/
# 获取app name
APP_NAME=${APP_PATH##*/}

#java应用添加lib路径
if [ ${APP_TYPE} == "java" ]; then
	APP_FULL_PATH=${APP_PATH}/lib/${APP_NAME}
elif [ ${APP_TYPE} == "go" ]; then
	APP_FULL_PATH=${APP_PATH}/${APP_NAME}
fi

# 检查应用是否在运行
function check_status() {
	echo "check running status..."
	tpid=$(ps -ef | grep -n "${APP_FULL_PATH}" | grep -v grep | grep -v kill | awk '{print $2}')
	if [ ${tpid} ]; then
		echo "${APP_NAME} is running."
		RUNNING="true"
	else
		echo "${APP_NAME} is NOT running."
		RUNNING="false"
	fi
}

# 启动程序
function start() {
	cd ${APP_PATH}
	# 检查是否已经存在
	check_status
	if [ ${RUNNING} == "true" ]; then
		echo "${APP_NAME} already running!"
	else
		echo "start..."
		if [ ${APP_TYPE} == "java" ]; then
			$(nohup java -cp ${APP_PATH}/conf:${APP_PATH}/lib/*:${APP_FULL_PATH}.jar ${ARGS} >${APP_PATH}/log/${APP_NAME}.out ${daemon})
		elif [ ${APP_TYPE} == "go" ]; then
			$(nohup ${APP_FULL_PATH} ${ARGS} >${APP_PATH}/log/${APP_NAME}.out ${daemon})
		else
			echo "APP_TYPE error!"
			exit 1
		fi
		# 检查程序是否启动成功
		while [ "${START_LIMIT}" -gt 0 ]; do
			check_status
			if [ ${RUNNING} == "true" ]; then
					echo "Start success!"
					exit 0
			else
					sleep 15
					check_status
					if [ ${RUNNING} == "true" ]; then
							echo "Start success!"
							exit 0
					fi
					let START_LIMIT--
					start
			fi
		done
		echo "Start fail!"
		exit 0
	fi
}

# 停止程序
function stop() {
	check_status
	if [ ${RUNNING} == "true" ]; then
		tpid=$(ps -ef | grep -n "${APP_FULL_PATH}" | grep -v grep | grep -v kill | awk '{print $2}')
		echo "Stop Process..."
		kill -15 ${tpid}
		# 检查程序是否已关闭
		while [ "${STOP_LIMIT}" -gt 0 ]; do
			check_status
			if [ ${RUNNING} == "true" ]; then
					sleep 6
					check_status
					if [ ${RUNNING} == "true" ]; then
						let STOP_LIMIT--
						stop
					else
						echo "stop success!"
						break
					fi		
			else
				echo "stop success!"
				break
			fi
		done
		# 强制杀死进程
		tpid=$(ps -ef | grep -n "${APP_FULL_PATH}" | grep -v grep | grep -v kill | awk '{print $2}')
		if [ ${tpid} ]; then
			echo "Kill Process!"
			kill -9 ${tpid}
		fi
	else
		echo "${APP_NAME} already stop!"
	fi
}

# 参数检查
if [ -z ${OPERATE} ]; then
	echo "OPERATE can not be null."
else
	# 启动程序
	if [ ${OPERATE} == "start" ]; then
		start
		# 停止程序
	elif [ ${OPERATE} == "stop" ]; then
		stop
		# 检查查询运行状态
	elif [ ${OPERATE} == "status" ]; then
		check_status
		# 重启程序
	elif [ ${OPERATE} == "restart" ]; then
		stop
		start
	else
		echo "Not supported the OPERATE."
	fi
fi