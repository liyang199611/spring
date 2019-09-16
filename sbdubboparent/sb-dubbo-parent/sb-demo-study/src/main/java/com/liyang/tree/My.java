package com.liyang.tree;

public class My{
    public static void main(String [] args) throws Exception{
        Integer x1 = new Integer(12);
        Integer x2 = new Integer(12);
        System.out.println(x1==x2);
        Integer x3 = Integer.valueOf(12);
        Integer x4 = Integer.valueOf(12);
        System.out.println(x3==x4);
        Integer x5 =4; // 装箱，调用了Integrt.valueOf()
        int x6 =4 ; // 拆箱 : x.intValue()
        System.out.println(x5==x6);
    }
}
