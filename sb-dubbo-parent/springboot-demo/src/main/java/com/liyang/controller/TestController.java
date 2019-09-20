package com.liyang.controller;

import com.liyang.exception.MyException;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping("/exception")
    public String excetionTest(@Param("i") int i) throws Exception{
        /**
         * 自定义异常拦截器
         */
        try {
            int x = 100/i;
        }catch (Exception e){
            throw new MyException("出现异常....");
        }
        return "1111";
    }
}
