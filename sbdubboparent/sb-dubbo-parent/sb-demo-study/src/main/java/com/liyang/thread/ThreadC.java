package com.liyang.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class TA extends Thread{
    @Override
    public void run() {
        System.out.println("Ta run");
    }
}


class TB extends Thread{
    private TA ta ;

    TB(TA ta){
        this.ta=ta;
    }
    @Override
    public void run() {

        try{
            ta.join();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Tb run");
    }
}

public class ThreadC {
    public static void main(String[] args){


//        TA ta = new TA();
//        Thread t1 = new Thread(ta);
//        t1.start();
//
//        TB tb = new TB(ta);
//        tb.start();
//        ta.start();

        ExecutorService executor = Executors.newCachedThreadPool();


        TA ta = new TA();
        TB tb = new TB(ta);
        executor.execute(ta);
        executor.execute(tb);
//        executor.shutdown();
        executor.shutdownNow();
    }
}
