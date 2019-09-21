package com.liyang.thread;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多线程抢红包
 */
class Users implements Runnable{
    private List<BigDecimal> baoList;
    private static ReentrantLock lock = new ReentrantLock(true);
    Users(List baoList){
        this.baoList = baoList;
    }

    public   void getMoney(){
        try{
            lock.lock();

            if(baoList.size()<=0){
                System.out.println(Thread.currentThread().getName()+"你手速慢了，没有抢到.....");
                return;
            }
            Random random = new Random();
            int index = random.nextInt(baoList.size());
            BigDecimal bigDecimal = baoList.get(index);
            baoList.remove(index); // 将已经抢到的红包删除
            System.out.println(bigDecimal);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }
    @Override
    public void run() {
        getMoney();
    }
}
class Bao {
    private double totalMoney; // 总的红包数量
    private int number ; // 总的红包数数
    Bao(double totalMoney,int number){
        this.totalMoney=totalMoney;
        this.number = number;
    }
    public List<BigDecimal> getBaoList(){
        BigDecimal bigDecimal = BigDecimal.valueOf(totalMoney);
        Random random = new Random();
        // 将元化成分
        int money = bigDecimal.multiply(BigDecimal.valueOf(100)).intValue();
        // 随机数总额
        double count = 0;
        // 每人获得随机点数
        double[] arrRandom = new double[number];
        List<BigDecimal> arrMoney = new ArrayList<BigDecimal>(number);
        // 循环人数 随机点
        for (int i = 0; i < arrRandom.length; i++) {
            int r = random.nextInt((number) * 99) + 1;
            count += r;
            arrRandom[i] = r;
        }
        // 计算每人拆红包获得金额
        int c = 0;
        for (int i = 0; i < arrRandom.length; i++) {
            // 每人获得随机数相加 计算每人占百分比
            Double x = new Double(arrRandom[i] / count);
            // 每人通过百分比获得金额
            int m = (int) Math.floor(x * money);
            // 如果获得 0 金额，则设置最小值 1分钱
            if (m == 0) {
                m = 1;
            }
            // 计算获得总额
            c += m;
            // 如果不是最后一个人则正常计算
            if (i < arrRandom.length - 1) {
                arrMoney.add(new BigDecimal(m).divide(new BigDecimal(100)));
            } else {
                // 如果是最后一个人，则把剩余的钱数给最后一个人
                arrMoney.add(new BigDecimal(money - c + m).divide(new BigDecimal(100)));
            }
        }
        // 随机打乱每人获得金额
        Collections.shuffle(arrMoney);
        return arrMoney;
    }

}

public class RedBall {
    public static void main(String [] args){
        // 开始创建多线程强红包
        int threadNumbers = 100;
        Bao bao = new Bao(1000,new Random().nextInt(threadNumbers)); // 分配随机的红包个数
        Users users = new Users(bao.getBaoList());
        Thread[] threads = new Thread[threadNumbers];
        for(int i=0;i<threads.length;i++){
            threads[i] = new Thread(users);
        }

        for (Thread thread:threads) {
            thread.start();
        }

    }
}
