package com.liyang.service.impl;

import com.liyang.mapper.SeckillGoodsMapper;
import com.liyang.mapper.SeckillOrdersMapper;
import com.liyang.pojo.SeckillGoods;
import com.liyang.pojo.SeckillOrders;
import com.liyang.service.SeckillGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SeckillGoodsServiceImpl implements SeckillGoodsService {
    @Autowired
    private SeckillGoodsMapper seckillGoodsMapper;

    @Autowired
    private SeckillOrdersMapper seckillOrdersMapper;

    @Override
    public void addSeckillGoods(List<SeckillGoods> seckillGoodsList) {
        seckillGoodsMapper.addSeckillGoods(seckillGoodsList);
    }

    @Override
    public List<SeckillGoods> getGoodsList() {
        return seckillGoodsMapper.getGoodsList();
    }

    @Override
    public SeckillGoods getGoodsByPid(String pid) {
        return seckillGoodsMapper.getGoodsByPid(pid);
    }

    @Transactional
    public boolean saveSeckillOrders(SeckillOrders seckillOrders, int qty, String pid) {
        try {
            seckillOrdersMapper.saveSeckillOrders(seckillOrders);
            seckillGoodsMapper.updateGoodsQty(pid, qty);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
