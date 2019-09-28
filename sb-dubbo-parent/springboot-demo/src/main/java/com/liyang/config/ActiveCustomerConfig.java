package com.liyang.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.Session;

@Configuration
public class ActiveCustomerConfig {
    //定义ActivMQ的连接地址
    private static final String ACTIVEMQ_URL = "tcp://192.168.17.21:23457";
    //定义发送消息的队列名称
    private static final String QUEUE_NAME = "springboot.queue.test";

    @Bean
    public MessageConsumer messageConsumer() {
        MessageConsumer consumer = null;
        try {
            //创建连接工厂
            ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
            //创建连接
            Connection connection = activeMQConnectionFactory.createConnection();
            //打开连接
            connection.start();
            //创建会话
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            //创建队列目标
            Destination destination = session.createQueue(QUEUE_NAME);
            //创建消费者
            consumer = session.createConsumer(destination);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return consumer;
    }
}
