package com.liyang.pojo;

public class UserBean {
    private String uid;
    private String name;
    private String phone;
    private String address;
    private String sex;
    private String job;
    UserBean(){}

    public String getUid() {
        return uid;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getSex() {
        return sex;
    }

    public String getJob() {
        return job;
    }

    public String getName() {
        return name;
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

    public void setJob(String job) {
        this.job = job;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserBean(String uid,String name,String phone,String address,String sex,String job){
        /**
         * 构造方法注入
         */
        this.uid = uid;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.sex = sex;
        this.job = job;

    }
    @Override
    public String toString() {
        return uid+","+name+","+phone+","+address+","+sex+","+job;
    }
}
