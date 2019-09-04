package com.liyang.mapper;

import com.liyang.pojo.UserBean;

import java.util.List;

public interface UserMapper {
    public List<UserBean> listUser();
    public List<UserBean>getUserByName(String name);
    public UserBean getUserByUid(String uid);

}
