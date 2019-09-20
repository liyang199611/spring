package com.liyang.mapper;

import com.liyang.pojo.UserBean;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    public List<UserBean> listUser();
    public List<UserBean>getUserByName(String name);
    public UserBean getUserByUid(String uid);
    public void addUser(@Param("userBean") UserBean userBean);
    @Select("select * from users")
    public List<UserBean> getAllUser();
}
