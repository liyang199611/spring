package com.liyang.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class MyTest  extends Thread {
    @Override
    public void run() {
        for(int i=0;i<1000;i++){
            System.out.println(Thread.currentThread().getName()+"---"+i);
        }
    }

    public static  void main(String [] args) throws Exception{
        MyTest myTest = new MyTest();
        Thread t1 = new Thread(myTest);
//        myTest.setDaemon(true);
//        myTest.start();
        for(int i=0;i<=10;i++){
//            System.out.println(Thread.currentThread().getName()+"--"+i);
        }

        final CountDownLatch countDownLatch = new CountDownLatch(10);
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for(int i=0;i<=11;i++){
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("strat");
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        System.out.println("end");
        executorService.shutdown();
    }
}
