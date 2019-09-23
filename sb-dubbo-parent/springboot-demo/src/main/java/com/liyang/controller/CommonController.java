package com.liyang.controller;

import com.liyang.common.MD5Utils;
import com.liyang.common.RedisUtils;
import com.liyang.common.ReturnMakeJson;
import com.liyang.exception.MyException;
import com.liyang.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CommonController {

    @Autowired
    private RedisUtils redisUtils;

    @RequestMapping("/")
    public Map<String, Object> getVersion(){
        /**
         * 获取软件版本消息
         */
        return new ReturnMakeJson().result();
    }


    @RequestMapping("/exception")
    public String excetionTest(@Param("i") int i) throws Exception{
        /**
         * 自定义异常拦截器
         */
        try {
            int x = 100/i;
        }catch (Exception e){
            throw new MyException("出现异常....");

        }
        ReturnMakeJson returnMakeJson = new ReturnMakeJson(10000,"出现异常",null);
        return new ReturnMakeJson(10000,"出现异常",null).result().toString();
    }

    @RequestMapping("/login")
    public Map login(@RequestBody User user){
        /**
         * 将用户密码加密保存到redis里面
         */
        if("".equals(user.getUsername()) || "".equals(user.getPassword())){
            ReturnMakeJson returnMakeJson = new ReturnMakeJson(10000,"用户密不能为空",null);
            return returnMakeJson.result();
        }
        String md5 = MD5Utils.makeToken(user);
        // 将缓存数据放入redis
        boolean flag = redisUtils.set(md5,user,2000);
        ReturnMakeJson returnMakeJson = new ReturnMakeJson();
        if(flag){
            returnMakeJson.setData(user.getUsername()+":"+md5);
        }else{
            returnMakeJson.setData(user.getUsername()+":获取token失败");
        }
        return returnMakeJson.result();
    }
}
