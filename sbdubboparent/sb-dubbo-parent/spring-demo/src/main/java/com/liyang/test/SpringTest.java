package com.liyang.test;
import com.liyang.pojo.CollectionBean;
import com.liyang.pojo.Product;
import com.liyang.pojo.ProductConfig;
import com.liyang.pojo.UserBean;
import com.liyang.service.ProductService;
import com.liyang.service.UserService;
import com.liyang.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class SpringTest {
    private ApplicationContext context =null;
    @Before
    public void  init(){
         context = new ClassPathXmlApplicationContext(new String[]{"application.xml"});
    }
    @Test
    public void test1(){
        UserBean userBean = (UserBean)context.getBean("user");
        String result = userBean.toString();
        System.out.println(result);
    }

    @Test
    public void testCollection(){
        /**
         * 测试集合
         */
        CollectionBean collectionBean = (CollectionBean) context.getBean("collectionBean");
        List<UserBean> list = collectionBean.getList();
        for (UserBean obj : list) {
            System.out.println(obj.toString());
        }
        System.out.println("****************************************");
        Map map = collectionBean.getMap();
        Object a = map.get("a");
        Object b = map.get("b");
        System.out.println(a);
        System.out.println(b);
        System.out.println("****************************************");
        Set set = collectionBean.getSet();
        for (Object obj:set) {
            System.out.println(obj);
        }
    }

    @Test
    public void testAop(){
        /**
         * 测试面向切面编程
         */
        UserService userService1 = (UserService) context.getBean("userService");
        UserService userService2 = (UserService) context.getBean("userService");
        System.out.println(userService1==userService2);
        userService1.sayHello();

    }

    @Test
    public void test4(){
        /**
         * 构造方法注入Bean对象
         */
        UserBean userBean = context.getBean("user",UserBean.class);
        System.out.println(userBean.toString());
    }

    @Test
    public  void test5(){
        ApplicationContext context = new AnnotationConfigApplicationContext(ProductConfig.class);
        Product product = context.getBean("product", Product.class);
        System.out.println(product.getAddress());
        System.out.println(product.getPid());
        System.out.println(product.getName());

    }

    @Test
    public void test6(){
        /**
         * 测试自动注入
         */
//        ProductService productService = context.getBean("productService",ProductService.class);
//        productService.getPro();

        UserService userService = context.getBean("userService",UserService.class);
        userService.getUser();

    }

    @Test
    public void test7(){
        context = new ClassPathXmlApplicationContext(new String[]{"jdbc.xml"});
        UserServiceImpl userService =  context.getBean("userService",UserServiceImpl.class);
//       userService.getAlUser();
       userService.getUserByUid("d626a914-f976-472c-9e86-d08bc7569609");
    }
}
