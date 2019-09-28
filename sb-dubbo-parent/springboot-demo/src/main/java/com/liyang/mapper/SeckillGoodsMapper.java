package com.liyang.mapper;

import com.liyang.pojo.SeckillGoods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SeckillGoodsMapper {
    public void addSeckillGoods(@Param("seckillGoodsList") List<SeckillGoods> seckillGoodsList);

    public List<SeckillGoods> getGoodsList();

    public SeckillGoods getGoodsByPid(@Param("pid") String pid);

    public void updateGoodsQty(@Param("pid") String pid,@Param("qty") int qty);
}
