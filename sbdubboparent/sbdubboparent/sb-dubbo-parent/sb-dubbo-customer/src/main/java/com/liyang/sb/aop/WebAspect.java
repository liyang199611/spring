package com.liyang.sb.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 演示springboot 面向切面编程
 */
@Component
@Aspect
public class WebAspect {
    /**
     * 切入点
     * 匹配com.liyang.sb.controller包及其子包下的所有类的所有方法
     */
    @Pointcut("execution(* com.liyang.sb.controller.*.*(..))")
    public void executePackage() {
        for(int i =0 ;i<=10000;i++){
            System.out.println(i);
        }
    }

    /**
     * 前置通知，目标方法调用前被调用
     * @param
     */
    @Before("executePackage()")
    public void beforeAdvice(JoinPoint joinPoint){
        System.out.println("- - - - - 前置通知 - - - - -");
        Signature signature = joinPoint.getSignature();
        System.out.println(signature.getName());
        Object [] args = joinPoint.getArgs();
        System.out.println("获取目标方法的参数信息："+ Arrays.toString(args));
    }


}