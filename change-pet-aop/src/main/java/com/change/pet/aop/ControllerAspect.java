package com.change.pet.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author zhaochangzhi
 * @date 2019/01/30
 */
@Aspect
public class ControllerAspect {

    /**
     * Controller层切点,注解方式
     */
    @Pointcut("execution(* *..controller..*Controller*.*(..))")
    public void controllerAspect() {

    }

    /**
     * 前置通知 (在方法执行之前返回)
     *
     * @param joinPoint 切点
     */
    @Before("controllerAspect()")
    public void doBefore(JoinPoint joinPoint) {
    }


    /**
     * 后置通知(在方法执行之后返回)
     *
     * @param joinPoint 切点
     */
    @After("controllerAspect()")
    public void doAfter(JoinPoint joinPoint) {
    }
}