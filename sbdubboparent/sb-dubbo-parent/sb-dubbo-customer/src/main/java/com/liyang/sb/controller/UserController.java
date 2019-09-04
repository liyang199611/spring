package com.liyang.sb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.liyang.sb.bean.UserBean;
import com.liyang.sb.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@RestController
public class UserController {
    @Reference(version = "20190823.1")
    private UserService userService;

    private String [] names = {"历阳","孙萌","张辉","陈凯"};

    @RequestMapping("/say")
    public String sayHello(String name){
//        String msg = userService.sayHello(name);
        String msg = "11111";
        System.out.println("2222222222222222222222");
        return msg;
    }

    @RequestMapping("/addUser")
    public String addUser(){
        List<UserBean> userList = new ArrayList<>();
        Random random = new Random();
        for(int i=1;i<=1000;i++){
            UserBean ub = new UserBean();
            ub.setUid(UUID.randomUUID().toString());
            ub.setName(names[random.nextInt(names.length)]);
            ub.setPhone("1562904"+random.nextInt(10000));
            ub.setJob("Java开发工程师");
            ub.setSex("男");
            ub.setAddress("湖北省丹江口市浪河镇");
            userList.add(ub);
        }
        userService.addUser(userList);
        return "add success";
    }

    @RequestMapping("/getUser")
    @ResponseBody
    public String getUserByUid(String uid){
        UserBean userBean = userService.getUserByUid(uid);
        if(userBean == null){
            return "没有该用户:"+uid;
        }
        return userBean.toString();
    }
}
