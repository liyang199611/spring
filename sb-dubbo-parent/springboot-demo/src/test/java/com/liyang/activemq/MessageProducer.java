package com.liyang.activemq;


import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * ActiveMq消息生产者
 */
public class MessageProducer {
    //定义ActivMQ的连接地址
    private static final String ACTIVEMQ_URL = "tcp://192.168.17.21:61616";
    //定义发送消息的队列名称
    private static final String QUEUE_NAME = "MyMessage";

    public static void main(String []args) throws JMSException {
        // 创建连接工厂
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        // 创建连接
        Connection connection = activeMQConnectionFactory.createConnection();
        // 打连接
        connection.start();
        // 创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //创建队列目标
        Destination destination = session.createQueue(QUEUE_NAME);

        // 创建一个生产者
        javax.jms.MessageProducer messageProducer = session.createProducer(destination);
        // 模拟创建100个消息
        for(int i=0;i<100;i++){
            TextMessage textMessage = session.createTextMessage("我生产消息了"+i);
            // 发送消息
            messageProducer.send(textMessage);
            // 本地打印消息
            System.out.println(textMessage.getText());
        }

        // 关闭连接
        connection.close();
    }
}
