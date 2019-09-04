package com.liyang.service.impl;

import com.liyang.pojo.UserBean;
import com.liyang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Autowired
    @Qualifier("user1")
    private UserBean userBean;

    // 注入jdbc连接池
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void sayHello() {
        System.out.println("hello 历阳");
    }

    @Override
    public void getUser() {
        System.out.println(userBean.toString());
    }

    @Override
    public void getAlUser() {
        /**
         * 获取所有用户
         */
        RowMapper<UserBean> rowMapper = new BeanPropertyRowMapper<UserBean>(UserBean.class);
        List <UserBean>userList = jdbcTemplate.query("select * from users",rowMapper);
        for (UserBean userBean:userList) {
            System.out.println(userBean.toString());
        }
    }

    @Override
    public void getUserByUid(String uid) {
        RowMapper<UserBean> rowMapper = new BeanPropertyRowMapper<UserBean>(UserBean.class);
        List<UserBean>userList = jdbcTemplate.query("select * from users where uid=?",rowMapper,uid);
        for (UserBean userBean:userList) {
            System.out.println(userBean.toString());
        }
    }
}






















