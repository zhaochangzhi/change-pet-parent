package com.change.pet.aop;

import org.aspectj.lang.JoinPoint;

/**
 * @author zhaochangzhi
 * @date 2019/01/30
 */
public class ControllerAspect {

    /**
     * Controller层切点,注解方式
     */
    public void controllerAspect() {

    }

    /**
     * 前置通知 (在方法执行之前返回)
     *
     * @param joinPoint 切点
     */
    public void doBefore(JoinPoint joinPoint) {
    }


    /**
     * 后置通知(在方法执行之后返回)
     *
     * @param joinPoint 切点
     */
    public void doAfter(JoinPoint joinPoint) {
    }
}