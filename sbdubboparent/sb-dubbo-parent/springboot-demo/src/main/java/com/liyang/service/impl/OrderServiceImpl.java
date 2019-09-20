package com.liyang.service.impl;

import com.liyang.exception.MyException;
import com.liyang.mapper.OrderMapper;
import com.liyang.pojo.Order;
import com.liyang.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

@Service // @Service用于标注业务层组件
public class OrderServiceImpl implements OrderService {
    private Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
    @Autowired
    private OrderMapper orderMapper;
    @Override
    @Transactional
    public void saveOrder(Order order) throws Exception{
        try {
            orderMapper.saveOrder(order);
        }catch (Exception e){
            logger.error("订单编号为["+order.getOid()+"]保存失败");
            e.printStackTrace();
        }
    }
}
