package com.liyang.sb.service;

import com.liyang.sb.bean.UserBean;

import java.util.List;

public interface UserService {
    public String sayHello(String name);

    public void addUser(List<UserBean> userList);

    public UserBean getUserByUid(String uid);
}
