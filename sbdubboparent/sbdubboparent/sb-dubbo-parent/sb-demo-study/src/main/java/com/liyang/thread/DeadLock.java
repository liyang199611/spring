package com.liyang.thread;

class User{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


class MyLocalThread extends Thread{
    private User u1;
    private User u2;
    int a;
    int b;
    boolean flag;
    MyLocalThread(User u1,User u2,int a , int b,boolean flag){
        this.a=a;
        this.b=b;
        this.u1=u1;
        this.u2=u2;
        this.flag=flag;
    }
    @Override
    public void run() {
        try{
            if(flag){
                synchronized (u1){
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName()+"1111111111111");
                    synchronized (u2){
                        System.out.println(a+b);
                    }
                }
            }else{
                synchronized (u2){
                    System.out.println(Thread.currentThread().getName()+"2222222222222");
                    synchronized (u1){
                        System.out.println(a*b);
                    }
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
public class DeadLock {
    public static void main(String [] args){
        final User u1 = new User();
        final User u2 = new User();

        int a =10;
        int b =10;

        MyLocalThread my1 = new MyLocalThread(u1,u2,a,b,true);
        MyLocalThread my2 = new MyLocalThread(u1,u2,a,b,false);

        Thread t1 =new Thread(my1);
        Thread t2 = new Thread(my2);

        System.out.println(Thread.currentThread().getName());

        t1.start();
        t2.start();

    }
}
