package com.change.pet.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author zhaochangzhi
 * @description 日志切面
 * @date 2019/1/30 19:42
 */
@Aspect
@Component
public class SystemLogAspect extends ControllerAspect {

	/**
	 * Controller层切点,注解方式
	 */
	@Override
	public void controllerAspect() {

	}

	/**
	 * 前置通知 (在方法执行之前返回)用于拦截Controller层记录用户的操作的开始时间
	 *
	 * @param joinPoint 切点
	 */
	@Override
	public void doBefore(JoinPoint joinPoint) {

	}


	/**
	 * 后置通知(在方法执行之后返回) 用于拦截Controller层操作
	 *
	 * @param joinPoint 切点
	 */
	@Override
	public void doAfter(JoinPoint joinPoint) {

	}
}