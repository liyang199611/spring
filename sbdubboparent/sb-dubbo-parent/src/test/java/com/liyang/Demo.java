package com.liyang;

public class Demo{
    public static void main(String[]args){
        Cat cat1=new Cat(1);
        cat1.rule();
        //System.out.println(cat1.getAge());
    }
}
class  Animal{
    public final void rule(){
        System.out.println("do not hurt people!");
    }
}
class Cat extends Animal{
    private int id=0;
    private int age=0;
    Cat(int id){this.id=id;}
    public void setAge(int age){
        this.age=age;
    }
    public int getAge(){
        return age;
    }
    /**
     * final 修饰的方法不可以被继承
     */
//    public final void rule(){
//        System.out.println("I want to hurt people!");
//    }
}