package com.liyang.test;

import java.util.*;

public class Test {
    static class A {
        public int a;

        public A(int a) {
            this.a = a;
        }
    }

    private static void fun(A a) {
        System.out.println(a.toString());
        a.a += 1;
    }
    public static void main(String[] args) {
        Integer a = 129;
        fun(a);
        System.out.println(a);// 输出结果为5
        String [] s = {"1","2"};
        System.out.println(s[0]);
        A x = new A(5) ;
        System.out.println(x.toString());
        fun(x);
        System.out.println(x.a);

        Set set = new HashSet();
        set.add(1);

        Set set1 = new TreeSet();
        Hashtable hashtable = new Hashtable();
        hashtable.put(null,null);
        List list = new ArrayList();

        Map map = new HashMap();


    }

    private static void fun(Integer a) {
        a += 1;
    }
    private static void fun2(String[] a) {
        a[0]="李洋";
    }

}