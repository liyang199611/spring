package com.liyang.thread;


import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyRunnable implements Runnable{
    private int num;
    private int init = 1;
    private String lock;

    public MyRunnable(int num,String lock){
        this.num = num;
        this.lock = lock;
    }

    @Override
    public void run() {
        while (true){    //这一行和下面不能交换，不然都是一个窗口把票卖完了
            synchronized (lock) {
                if (init > num) {
                    System.out.println("火车票已经卖完了");
                    return;
                }
                try {
                    //模拟出票过程，否则因为执行太快，大部分被一个线程执行完了
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "售出火车票：" + init++);
            }
        }
    }
}


public class ThreadB {
    public static void main(String [] args){

//        ExecutorService ec = Executors.newCachedThreadPool();
//        for(int i =0;i<=1000;i++){
//            ec.execute(new MyRunnable());
//        }
//        ec.shutdown();


        MyRunnable my = new MyRunnable(100,"lock");
        Thread t1 = new Thread(my);
        t1.setName("历阳-1");

        MyRunnable my2 = new MyRunnable(100,"lock");
        Thread t2 = new Thread(my2);
        t2.setName("历阳-2");

//        Thread t3 = new Thread(my);
//        t3.setName("历阳-2");
//
//        Thread t4 = new Thread(my);
//        t4.setName("历阳-4");

        t1.start();
        t2.start();
//        t3.start();
//        t4.start();

    }
}
