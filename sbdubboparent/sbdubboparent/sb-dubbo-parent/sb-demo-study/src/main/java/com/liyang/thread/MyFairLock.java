package com.liyang.thread;

import javax.management.relation.RoleUnresolved;
import java.util.concurrent.locks.ReentrantLock;

public class MyFairLock {
    /**
     *     true 表示 ReentrantLock 的公平锁
     */
    private static ReentrantLock lock = new ReentrantLock(false);

    public  static void testFail(){
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() +"获得了锁");
        }finally {
            lock.unlock();
        }
    }
    public static class My implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+"启动");
            MyFairLock.testFail();
        }
    }
    public static void main(String[]args) {
        MyFairLock myFairLock = new MyFairLock();
        My my = new My();
        Thread[] threadArray = new Thread[10];
        for (int i=0; i<10; i++) {
            threadArray[i] = new Thread(my);
        }
        for (int i=0; i<10; i++) {
            threadArray[i].start();
        }
    }

}
