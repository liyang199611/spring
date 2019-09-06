package com.liyang.pojo;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable {
    private String sid; // 学号
    private String name; // 姓名
    private Date birthday; // 生日
    private String sex; // 性别
    private String address; // 家庭地址
    private int classes; // 班级

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getSex() {
        return sex;
    }

    public Date getBirthday() {
        return birthday;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public int getClasses() {
        return classes;
    }

    public void setClasses(int classes) {
        this.classes = classes;
    }
}
