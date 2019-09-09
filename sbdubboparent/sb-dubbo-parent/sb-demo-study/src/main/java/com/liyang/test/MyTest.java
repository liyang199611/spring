package com.liyang.test;

public class MyTest  extends Thread{
    @Override
    public void run() {
        for(int i=0;i<1000;i++){
            System.out.println(Thread.currentThread().getName()+"---"+i);
        }
    }

    public static  void main(String [] args){
        MyTest myTest = new MyTest();
        Thread t1 = new Thread(myTest);
//        myTest.setDaemon(true);
        myTest.start();
        for(int i=0;i<=10;i++){
            System.out.println(Thread.currentThread().getName()+"--"+i);
        }
    }
}
