package com.liyang.test;

import com.liyang.common.Common;
import com.liyang.pojo.Club;
import com.liyang.pojo.Student;
import com.liyang.service.StudentService;
import com.liyang.service.impl.ClubServiceImpl;
import com.liyang.service.impl.StudentServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;

public class MyTest {
    final Map<String,String> map = new HashMap<String, String>();
    ApplicationContext context = null;
    final String [] sex ={"男","女"};
    final String [] address = {"湖北十堰","湖北丹江","湖北武汉","湖北襄阳"};
    final String [] names = {"张辉","历阳","陈凯","郭阳","李雪丹"};
    @Before
    public void init(){
        map.put("1","张老师");
        map.put("2","历老师");
        map.put("3","孙老师");
        context = new ClassPathXmlApplicationContext("application.xml");
    }
    @Test
    public void testAddStu(){
        /**
         * 班级添加学生
         */
        StudentServiceImpl studentService = context.getBean("studentService", StudentServiceImpl.class);
        ClubServiceImpl clubService = context.getBean("clubService", ClubServiceImpl.class);
        Student student = new Student();
        Date birthday = Common.getBrithday();
        Random random = new Random();
//        student.setSid(random.nextInt(100000000));
        student.setName("历阳");
        student.setAddress("湖北省丹江口市浪河镇");
        student.setBirthday(birthday);
        student.setSex("男");

        Club club = new Club();
        club.setClasses("1");
        club.setTeacher("张老师");
//        studentService.addStu(student,club);
        clubService.addClub(club);
    }

    @Test
    public void addManyStu(){
        // 添加多个学生
        StudentServiceImpl studentService = context.getBean("studentService", StudentServiceImpl.class);
        ClubServiceImpl clubService = context.getBean("clubService", ClubServiceImpl.class);
        Random random = new Random();
        for(int i =0 ;i<=150;i++){
            int random_sex = random.nextInt(2);
            int random_addr = random.nextInt(4);
            int random_name = random.nextInt(5);
            Student stu = new Student();
            stu.setSid(UUID.randomUUID().toString().replace("-","").toUpperCase());
            stu.setSex(sex[random_sex]);
            stu.setBirthday(Common.getBrithday());
            stu.setAddress(address[random_addr]);
            stu.setClasses(random.nextInt(3)+1);
            stu.setName(names[random_name]+i);
            studentService.addStu(stu);
        }

        for(String key : map.keySet()){
            Club club = new Club();
            String value = map.get(key);
            club.setClasses(key);
            club.setTeacher(value);
            clubService.addClub(club);
        }
    }
}
