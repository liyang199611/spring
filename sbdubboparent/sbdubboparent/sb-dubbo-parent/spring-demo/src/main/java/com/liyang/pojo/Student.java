package com.liyang.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
@Component(value ="student") //Spring IoC 会把这个类扫描成一个 bean 实例
public class Student {
    @Value("0001")
    private String id;
    @Value("历阳")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void printInfo(){
        System.out.println(id+"----"+name);
    }
}
