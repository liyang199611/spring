package com.liyang.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 线程的三种创建方式
 */
class CreateA implements Runnable{
    @Override
    public void run() {
        System.out.println("我是实现Runnable创建线程的方式");
    }
}

class CreateB extends Thread{
    @Override
    public void run() {
        System.out.println("我是继承Thread类创建线程");
    }
}

class CreateC implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {
        System.out.println("我是实现Callable接口创建线程");
        return 11;
    }
}
public class ThreadA {
    public static void main(String [] args) throws Exception{
        CreateA a = new CreateA();
        Thread t1 = new Thread(a);
        t1.start();



        CreateB b = new CreateB();
        Thread t2 = new Thread(b);
        t2.start();

        CreateC c = new CreateC();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(c);
        Thread t3 = new Thread(futureTask);
        t3.start();
        Integer ft = futureTask.get();
        System.out.println(ft);

    }
}
