package com.liyang.service;

import com.liyang.exception.MyException;
import com.liyang.pojo.Order;

public interface OrderService {
    public void saveOrder(Order order) throws Exception;
}
