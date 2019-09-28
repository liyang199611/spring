package com.liyang.service;

import com.liyang.pojo.SeckillGoods;
import com.liyang.pojo.SeckillOrders;

import java.util.List;

public interface SeckillGoodsService {
    public void addSeckillGoods(List<SeckillGoods> seckillGoodsList);

    public List<SeckillGoods> getGoodsList();

    public SeckillGoods getGoodsByPid(String pid);
    public boolean saveSeckillOrders (SeckillOrders seckillOrders,int qty,String pid); // 生成订单接口
}
