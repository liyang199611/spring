package com.liyang.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class LoggerAspect {
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("start log"+joinPoint.getSignature().getName());
        Object object = joinPoint.proceed();
        System.out.println("end log"+joinPoint.getSignature().getName());
        return object;
    }
    public void mylog(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName()+"before");

    }
}
