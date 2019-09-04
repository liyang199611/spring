package com.liyang.sb.bean;

import java.io.Serializable;

/**
 * 用户的实体类
 */

public class UserBean implements Serializable {
    private String uid;
    private String name;
    private String phone;
    private String address;
    private String sex;
    private String job;

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getSex() {
        return sex;
    }

    public String getName() {
        return name;
    }

    public String getUid() {
        return uid;
    }

    public String getJob() {
        return job;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return uid+","+name+","+phone+","+address+","+sex+","+job;
    }
}
