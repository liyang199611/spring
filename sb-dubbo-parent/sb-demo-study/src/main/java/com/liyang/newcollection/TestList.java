package com.liyang.newcollection;

import org.junit.Test;

import java.util.*;

/**
 * 集合的学习
 */
public class TestList {
    @Test
    public void test1(){
        /**
         * list 集合，有序集合，允许存放重复的元素、
         * 实现类：
         * ArrayList：数组实现，查询快，增删慢，轻量级；(线程不安全)
         * LinkedList：双向链表实现，增删快，查询慢 (线程不安全)
         * Vector：数组实现，重量级  (线程安全、使用少)
         */
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Object x = list.get(2);
//        System.out.println(x);
        list.remove(1);

        Vector vector = new Vector();
        vector.add("111");
        vector.add("111");
        for (Object o:vector) {
//            System.out.println(o);
        }

        Set set = new HashSet();
        set.add("aaa");
        set.add("aaa");
        System.out.println(set.size());
    }
}
