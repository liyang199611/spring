package com.liyang.component;

import com.liyang.pojo.Order;
import com.liyang.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

@Component //把普通pojo实例化到spring容器中，相当于配置文件中的<bean id="" class=""/>
public class JMSCustomer {
    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    // 在这里注入多线程来接收消息
    @Autowired
    private OrderService orderService;

    private Logger logger = LoggerFactory.getLogger(JMSCustomer.class);

    @JmsListener(destination = "springboot.queue.test") // springboot 自动注入监听器
    public void receiveQueen(String msg){
        try{
            String orderInfo [] =  msg.split(",");
            String oid = orderInfo[0];
            String name = orderInfo[1];
            String address = orderInfo[2];
            Order order = new Order();
            order.setAddress(address);
            order.setOid(oid);
            order.setName(name);
            orderService.saveOrder(order);
            logger.info(Thread.currentThread().getName()+":" + msg);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
