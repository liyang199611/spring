package com.liyang.mapper;

import com.liyang.pojo.UserBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    public List<UserBean> listUser();
    public List<UserBean>getUserByName(String name);
    public UserBean getUserByUid(String uid);
    public void addUser(@Param("userBean") UserBean userBean);
}
