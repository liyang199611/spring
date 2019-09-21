package com.liyang.pojo;

import org.junit.Before;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestBean {
    @Bean(name = "testBean1") //@Bean 注解，注解到方法之上，使其成为 Spring 中返回对象为 Spring 的 Bean 资源
    public String test(){
        return "我是注解在方法上面";
    }
}
