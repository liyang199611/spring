package com.liyang.service;

import com.liyang.pojo.UserBean;

import java.util.List;

public interface UserService {
    public void sayHello();
    public void getUser();
    public void getAlUser();
    public void getUserByUid(String uid);
}
