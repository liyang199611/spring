package com.liyang.thread;


import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MyThread extends  Thread{
    Lock lock = new ReentrantLock();
    @Override
    public void run() {
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+"获得了锁");
            Thread.sleep(20);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
//            lock.unlock();
//            System.out.println(Thread.currentThread().getName()+"释放了锁");
        }
    }
}

public class LockTest {
    public static void main(String [] args){
//        MyThread myThread = new MyThread();
//        Thread t1 = new Thread(myThread);
//        t1.setName("线程1");
//        Thread t2 = new Thread(myThread);
//        t2.setName("线程2");
//        t1.start();
//        t2.start();
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();
        Thread t1 = new Thread(myThread1);
        t1.setName("线程1");
        Thread t2 = new Thread(myThread1);
        t2.setName("线程2");
        t1.start();
        t2.start();
    }
}
