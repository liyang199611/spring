package com.liyang.mapper;

import com.liyang.pojo.SeckillOrders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SeckillOrdersMapper {
    public void saveSeckillOrders(@Param("seckillOrders") SeckillOrders seckillOrders);
}
