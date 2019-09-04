package com.liyang.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class SynchronizedExample extends Thread{
    public void run() {
        /**
         * 同步一个方法，同步一个代码块，它只作用于同一个对象，如果调用两个对象上的同步代码块，就不会进行同步。
         */
        synchronized (SynchronizedExample.class) {
            for (int i = 0; i <= 20; i++) {
                try {
                    Thread.sleep(10);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.print(" " + i);
            }
        }
    }
}


class SynchronizedExample_2 extends Thread{
    @Override
    public void run() {
        /**
         * 作用于整个类，也就是说两个线程调用同一个类的不同对象上的这种同步语句，也会进行同步。
         */
        synchronized (SynchronizedExample_2.class) {
            for (int i = 0; i <= 20; i++) {
                try {
                    Thread.sleep(20);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.print(" " + i);
            }
        }
    }
}


class LockExample extends Thread{
    private Lock lock =new ReentrantLock();
    /**
     * 同步锁demo
     */
    public void test(){
        try{
            lock.lock();
            System.out.println(Thread.currentThread().getName()+"得到了锁");
            for(int i =0 ;i<=20;i++){
                try{
                    Thread.sleep(1);
                }catch (Exception e){
                    e.printStackTrace();
                }
                System.out.print(" "+i);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
            System.out.println(Thread.currentThread().getName()+"释放了锁");
        }

    }
    @Override
    public void run() {
        test();
    }

}

class SynchronizedExample_3 extends Thread{
    /**
     * 同步一个方法:它和同步代码块一样，作用于同一个对象。
     */
    public synchronized  void test(){
        for(int i =0 ;i<=20;i++){
            try{
                Thread.sleep(20);
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.print(" "+i);
        }
    }

    /**
     * 同步一个静态方法，作用于真个类
     */
    public synchronized static void test1(){
        for(int i =0 ;i<=20;i++){
            try{
                Thread.sleep(20);
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.print(" "+i);
        }
    }
    @Override
    public void run() {
       test1();
    }
}
public class ThreadE {
    public static void main(String [] args){
//        SynchronizedExample e1 = new SynchronizedExample();
//        SynchronizedExample e2 = new SynchronizedExample();
//        Thread t1 = new Thread(e1);
//        Thread t2 = new Thread(e2);
//        t1.start();
//        t2.start();

//        SynchronizedExample_2 e3 = new SynchronizedExample_2();
//        SynchronizedExample_2 e4 = new SynchronizedExample_2();
//        Thread t3 = new Thread(e3);
//        Thread t4 = new Thread(e4);
//        t3.start();
//        t4.start();

//        SynchronizedExample_3 e5 = new SynchronizedExample_3();
//        SynchronizedExample_3 e6 = new SynchronizedExample_3();
//        Thread t5 = new Thread(e5);
//        Thread t6 = new Thread(e6);
//        t5.start();
//        t6.start();

        LockExample le1 = new LockExample();
        LockExample le2 = new LockExample();
        Thread l1 = new Thread(le1);
        l1.setName("线程1");
        Thread l2 = new Thread(le2);
        l2.setName("线程2");
        l1.start();
        l2.start();
    }
}
