package com.liyang.controller;

import com.liyang.common.ReturnMakeJson;
import com.liyang.component.JMSProducer;
import com.liyang.exception.MyException;
import com.liyang.pojo.Order;
import com.liyang.service.OrderService;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.jms.Destination;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.locks.ReentrantLock;

@RestController //@Controller用于标注控制层组件(如struts中的action)
public class OrderController {
    private Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private ThreadPoolTaskExecutor executor;

    @Autowired
    private OrderService orderService;

    @Autowired
    private JMSProducer jmsProducer;

    private ReentrantLock lock = new ReentrantLock();
    final BlockingDeque<Order> blockingDeque = new LinkedBlockingDeque<Order>();

    public void saveOrder(BlockingDeque<Order> blockingDeque) throws Exception{
        while (blockingDeque.take()!=null) {
            Order order = blockingDeque.take();
            orderService.saveOrder(order);
        }
    }
    @RequestMapping(value = "receive",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Map<String, Object> receiveOrder(@RequestBody final List<Order> orderList) throws MyException{
        /**
         * 这里演示多线程接收订单数据
         */
        try{
            lock.lock();
            for (int i =0;i<orderList.size();i++) {
                blockingDeque.put(orderList.get(i));
                if(i==5000){
                    continue;
                }
            }
            logger.info("队列里面有"+blockingDeque.size()+"条数据");
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
            logger.error("出现异常"+e.getMessage());
            throw new MyException(e.getMessage());
        }finally {
            lock.unlock();
        }
        return ReturnMakeJson.result();
    }

    @RequestMapping(value = "/getorder",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Map receive(@RequestBody List<Order> orderList){
        /**
         * 演示activemq 异步接收订单数据
        */
        Destination destination = new ActiveMQQueue("springboot.queue.test");
        for (Order order:orderList) {
            try {
                jmsProducer.sendMessage(destination,order.toString());
            }catch (Exception e){
                e.printStackTrace();
                logger.error(order.getOid()+"发送到activemq失败");
            }
        }
        return ReturnMakeJson.result();
    }
}
