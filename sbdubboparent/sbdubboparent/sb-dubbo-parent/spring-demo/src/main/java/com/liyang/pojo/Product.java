package com.liyang.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
@Component(value = "product")
public class Product {
    @Value("00001")
    private String pid;
    @Value("华为nove3i")
    private String name;
    @Value("湖北省丹江口市")
    private String address;

    public void setName(String name) {
        this.name = name;
    }

    public String getPid() {
        return pid;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
}

