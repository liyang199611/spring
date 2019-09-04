package com.liyang.collection;

import org.junit.Test;

import java.util.*;

public class MyTest {
    @Test
    public void testList(){
        ListDemo li = new ListDemo(10);
        for(int i =0;i<1000;i++){
            li.add(i);
        }
        System.out.println(li.getSize());
        System.out.println(li.get(3));

    }

    @Test
    public void testVectory(){
        // Vector 是线程安全的
        Vector vc = new Vector();
        vc.add(1);
        vc.add(1);
        System.out.println(vc.size());

        Set set = new HashSet<>();
        set.add(1);
        set.add(1);
        System.out.println(set.size());

        Map map = new TreeMap();
        map.put("1",1);
        map.put("2",2);
        Object x = map.get("1");
        System.out.println(x);

        int a =1999999999;
        byte b = (byte)a;
        System.out.println(b);

    }
}
