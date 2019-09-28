package com.liyang.component;

import com.liyang.pojo.Order;
import com.liyang.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import javax.jms.*;


@Component
public class ThreadCustomer {
    @Autowired
    private MessageConsumer messageConsumer; // 自定义监听器

    @Autowired
    private ThreadPoolTaskExecutor executor;

    @Autowired
    private OrderService orderService;

    private Logger logger = LoggerFactory.getLogger(ThreadCustomer.class);


    public void thread(){
        try{
            messageConsumer.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    TextMessage textMessage = (TextMessage) message;
                    try {
                        String msg = textMessage.getText();
                        String orderInfo [] =  msg.split(",");
                        String oid = orderInfo[0];
                        String name = orderInfo[1];
                        String address = orderInfo[2];
                        Order order = new Order();
                        order.setAddress(address);
                        order.setOid(oid);
                        order.setName(name);
                        try{
                            orderService.saveOrder(order);
                            logger.info(Thread.currentThread().getName()+":" + textMessage.getText());
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void receive(){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                thread();
            }
        });
    }


}
