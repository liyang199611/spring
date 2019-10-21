package com.liyang.datatype;

import java.util.*;

class A{
    public  void eat(){
        System.out.println("AAAAAAAAAAAAAAAAAAAA");
    }
}
class B extends A{

   public void eat(){
       System.out.println("BBBBBBBBBBBBBBBBBBBBB");
       super.eat();
   }

}
public class IntegerDemo {
    public static void main(String [] args){
        // 基本类型都有对应的包装类型，基本类型与其对应的包装类型之间的赋值使用自动装箱与拆箱完成
        //        Integer x = 2;     // 装箱 调用了 Integer.valueOf(2)
        //        int y = x;         // 拆箱 调用了 X.intValue()
        Integer x = new Integer(123);
        Integer y = new Integer(123);
        System.out.println(x.equals(y));
        System.out.println(x==y);

        Integer x1 = Integer.valueOf(127);
        Integer x2 = Integer.valueOf(127);
        System.out.println(x1==x2);
        B b = new B();
        b.eat();
        List list = new Vector();
        list.add(1);

        Map map = new HashMap();
        map.put(1,2);
    }
}
