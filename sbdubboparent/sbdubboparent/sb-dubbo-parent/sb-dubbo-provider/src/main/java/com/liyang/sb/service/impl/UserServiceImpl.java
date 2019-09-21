package com.liyang.sb.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.liyang.sb.bean.UserBean;
import com.liyang.sb.mapper.UserMapper;
import com.liyang.sb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Service(version = "20190823.1",timeout = 3000)
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public String sayHello(String name) {
        return "hello wrold"+name;
    }

    @Override
    public void addUser(List<UserBean> userList) {
        /**
         * 将数据写入到redis里面
         */
        userMapper.addUser(userList);
        if(userList != null){
            for (UserBean ub : userList) {
                String uid = ub.getUid();
                // 看redis里面是否存在这个用户
                if (redisTemplate.hasKey(uid)){
                    System.out.println(uid+"改用户存在,pass");
                }else{
                    redisTemplate.opsForValue().set(uid,ub);
                }
            }
        }
    }

    @Override
    public UserBean getUserByUid(String uid) {
        // 先从redis里面获取
        UserBean userBean = (UserBean)redisTemplate.opsForValue().get(uid);
        if(null == userBean){
             userBean = userMapper.getUserByUid(uid);
        }
        return userBean;
    }
}
