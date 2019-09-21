package com.liyang.thread;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadD {
    private static class MyThread extends Thread{
        @Override
        public void run() {
            try{
                Thread.sleep(2000);
                System.out.println("thread run");
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }


    public static   class MyThread2 extends Thread{
        @Override
        public void run() {
            while (!interrupted()){
                System.out.println("线程未中断");
            }
            System.out.println("end .........");
        }
    }
    public static void main(String[]args){
//        MyThread myThread = new MyThread();
//        myThread.start();
//        myThread.interrupt();
//        System.out.println("main run");


        MyThread2 myThread2 = new MyThread2();
        myThread2.start();
        myThread2.interrupt();
        System.out.println("main .....");



    }
}
