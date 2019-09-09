package com.liyang.test;

import com.liyang.collection.MyTest;
import jdk.nashorn.internal.scripts.JD;
import org.junit.Test;

import javax.swing.*;
import java.util.*;

interface A{
    /**
     * 接口时需要子类去访问的，如果是私有的，无法
     */
//    int a;
//    protected int a =2;
//    private int b= 3;
//    private void say();
}
public class Test1 {
    @Test
    public void test1(){
        /**
         *final 修饰的类不可以被继承，修饰的方法不可以被重写，修饰的变量不可以变，修饰的对象的引用不可以变，内容还是可以变的
         */
        String  s1 = "历史";
        final String s = "历史";
//        s = "";

        final MyTest myTest = new MyTest();
        MyTest my1 = new MyTest();
//        myTest = my1;
//        myTest = new MyTest();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("1");

        StringBuffer sbf = new StringBuffer();
        sbf.append("111");
        String x1 = sbf.toString();
        System.out.println(x1);
    }

    @Test
    public void test2(){
        String s1 = new String("aaaa");
        String s2 = new String("aaaa");
        System.out.println(s1==s2);
        String s3 = s1.intern();
        String s4 = s1.intern();
        System.out.println(s3==s4);
    }

    @Test
    public void test3(){
        Set set = new HashSet();
        Vector vector = new Vector();
        vector.add("");

        List list = new ArrayList();
        // 获取一个线程安全的集合
        List list1 = Collections.synchronizedList(list);
    }
}
