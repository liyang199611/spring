package com.liyang.mapper;

import com.liyang.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderMapper {
    public void saveOrder(@Param("order") Order order);
}