package com.liyang.controller;

import com.liyang.pojo.Order;
import com.liyang.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.locks.ReentrantLock;

@RestController
public class OrderController {

    @Autowired
    private ThreadPoolTaskExecutor executor;

    @Autowired
    private OrderService orderService;

    private ReentrantLock lock = new ReentrantLock();

    final BlockingDeque<Order> blockingDeque = new LinkedBlockingDeque();

    public void saveOrder(BlockingDeque<Order> blockingDeque) throws Exception{
        while (blockingDeque.take()!=null) {
            Order order = blockingDeque.take();
            System.out.println(Thread.currentThread().getName() + ":保存了订单");
            orderService.saveOrder(order);
        }
    }


    @RequestMapping(value = "receive",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String receiveOrder(@RequestBody final List<Order> orderList) throws Exception{
        try{
            lock.lock();
            for (int i =0;i<orderList.size();i++) {
                blockingDeque.put(orderList.get(i));
                if(i==5000){
                    continue;
                }
            }
//            Thread.sleep(100000);
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try{
                        saveOrder(blockingDeque);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return "1111111";
    }
}
