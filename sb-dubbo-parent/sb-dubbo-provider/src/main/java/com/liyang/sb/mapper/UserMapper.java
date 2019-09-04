package com.liyang.sb.mapper;


import com.liyang.sb.bean.UserBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    public void addUser(@Param("userList") List<UserBean>userList);
    public UserBean getUserByUid(@Param("uid") String uid);
}
