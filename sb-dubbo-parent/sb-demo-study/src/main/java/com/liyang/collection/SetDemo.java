package com.liyang.collection;


import org.junit.Test;

import java.util.*;


class A{
    public void say(){

    }
}
class B extends  A{
    @Override
    public void say() {
        super.say();
    }
    public void say(String name){

    }
}
abstract class C{
    public abstract  void eat();

    public void say(){

    }
}
class D extends C{
    @Override
    public void eat() {

    }
}
public class SetDemo {

    @Test
    public void setTest(){
        Set treeSet = new TreeSet();
        treeSet.add("1");
        treeSet.add("2");
        boolean result = treeSet.add("2");
        System.out.println(treeSet.size());
        System.out.println(result);
    }

    @Test
    public void listDemo(){
        List list = new ArrayList();
        for (int i=0;i<=10;i++){
            list.add(i);
        }
        int x = (int)list.get(1);
        System.out.println(x);
    }
}
