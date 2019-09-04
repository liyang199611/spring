package com.liyang.thread;

/**
 *
 * 测试几种线程同步方式
 */
public class SynObj {

    public synchronized void showA(){
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        try {
            Thread.sleep(3000);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void showB(){
        synchronized (this){
            System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBBB");
        }
    }

    public void showC(){
        String s = "1";
        synchronized (s){
         System.out.println("CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC");
        }
    }
}


