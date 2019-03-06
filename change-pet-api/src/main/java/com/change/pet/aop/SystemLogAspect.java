package com.change.pet.aop;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author zhaochangzhi
 * @description 日志切面
 * @date 2019/1/30 19:42
 */
@Aspect
@Component
@Log4j2
public class SystemLogAspect extends ControllerAspect {

	/**
	 * Controller层切点,注解方式
	 */
	@Override
	@Pointcut("execution(* *..controller..*Controller*.*(..))")
	public void controllerAspect() {

	}

	/**
	 * 前置通知 (在方法执行之前返回)用于拦截Controller层记录用户的操作的开始时间
	 *
	 * @param joinPoint 切点
	 */
	@Override
	@Before("controllerAspect()")
	public void doBefore(JoinPoint joinPoint) {
		log.info("controller前置切面");
	}

	/**
	 * 后置通知(在方法执行之后返回) 用于拦截Controller层操作
	 *
	 * @param joinPoint 切点
	 */
	@Override
	@After("controllerAspect()")
	public void doAfter(JoinPoint joinPoint) {
		log.info("controller后置切面");
	}
}