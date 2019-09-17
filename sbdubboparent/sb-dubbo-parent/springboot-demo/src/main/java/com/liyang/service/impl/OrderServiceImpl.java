package com.liyang.service.impl;

import com.liyang.mapper.OrderMapper;
import com.liyang.pojo.Order;
import com.liyang.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Override
    public void saveOrder(Order order) {
        orderMapper.saveOrder(order);
    }
}
