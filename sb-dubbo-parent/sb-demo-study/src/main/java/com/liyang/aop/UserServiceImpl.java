package com.liyang.aop;

public class UserServiceImpl implements UserService{
    @Override
    public void addUser() {
        System.out.println("新建用户");
    }
}
