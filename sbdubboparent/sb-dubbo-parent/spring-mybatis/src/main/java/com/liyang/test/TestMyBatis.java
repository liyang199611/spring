package com.liyang.test;

import com.liyang.mapper.UserMapper;
import com.liyang.pojo.UserBean;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMyBatis {

    SqlSession session = null;
    @Before
    public void init() throws IOException{
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 然后根据 sqlSessionFactory 得到 session
        session = sqlSessionFactory.openSession();
    }
    @Test
    public void listUser(){
        // 最后通过 session 的 selectList() 方法调用 sql 语句 listStudent
        List<UserBean> listUser = session.selectList("listUser");
        for (UserBean userBean : listUser) {
            System.out.println(userBean.toString());
        }
    }

    @Test
    public void getUserCount(){
        Integer count = session.selectOne("getCount",Integer.class);
        System.out.println(count);
    }

    @Test
    public void getUserByName(){
        List<UserBean> userList = session.selectList("getUserByName","历阳");
        for (UserBean userBean:userList) {
            System.out.println(userBean.toString());
        }
    }

    // 下面演示动态代理
    @Test
    public void testMapper(){
        UserMapper userMapper = session.getMapper(UserMapper.class);
//        List<UserBean> userBeanList = userMapper.listUser();
//        for (UserBean userBean:userBeanList) {
//            System.out.println(userBean.toString());
//        }
//        List<UserBean> userBeanList = userMapper.getUserByName("孙萌");
//        for (UserBean userBean:userBeanList) {
//            System.out.println(userBean.toString());
//        }
        UserBean userBean = userMapper.getUserByUid("d626a914-f976-472c-9e86-d08bc7569609");
        System.out.println(userBean);
    }
}
