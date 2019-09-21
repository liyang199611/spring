package com.liyang.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 自定义异常拦截器材
 */
@ControllerAdvice
public class MyExceptionHandler {
    /**
     * 默认异常拦截器
     * @param e
     */
    @ExceptionHandler(value = Exception.class)
    public void defaultExceptionHandler(Exception e){
        System.out.println(String.format("开始异常处理: %s", e.getMessage()));
        e.printStackTrace();
    }

    /**
     * 自定义异常拦截器
     * @param e
     */
    @ExceptionHandler(value = MyException.class)
    public void myExceptionHandler(MyException e){
        System.out.println("出现自定义异常了 : " + e.getMessage());
    }
}
