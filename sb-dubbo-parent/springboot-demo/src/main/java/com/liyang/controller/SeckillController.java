package com.liyang.controller;

import com.liyang.common.BigdecimalUtils;
import com.liyang.common.IDUtils;
import com.liyang.common.ReturnMakeJson;
import com.liyang.pojo.SeckillGoods;
import com.liyang.pojo.SeckillOrders;
import com.liyang.service.SeckillGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 秒杀系统控制层:
 * 业务描述:
 * 多用户抢购商品，包含的实体类有User , Product , Order
 */
@RestController
public class SeckillController {
    @Autowired
    private  SeckillGoodsService seckillGoodsService;

    Random random = new Random();
    SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );

    // 加锁优化
    private Lock lock = new ReentrantLock();


    // 创建一个添加商品的接口
    @RequestMapping("/addgoods")
    public Map<String, Object> addGoods(){
        String[] goodsNameList= IDUtils.goodsNames;
        List<SeckillGoods> seckillGoodsList = new ArrayList<>(goodsNameList.length);
        Random random = new Random(1000);
        for (int i=0;i<goodsNameList.length;i++) {
            SeckillGoods seckillGoods = new SeckillGoods();
            seckillGoods.setPid(IDUtils.getPid());
            seckillGoods.setPname(goodsNameList[i]);
            seckillGoods.setPrice(random.nextDouble()*10);
            seckillGoods.setQty(random.nextInt(1000));
            seckillGoodsList.add(seckillGoods);
        }
        // 保存商品
        seckillGoodsService.addSeckillGoods(seckillGoodsList);
        return new ReturnMakeJson().result();
    }

    @RequestMapping("/skillOrder")
    public Map skillGoods(@RequestParam String uid){
        // 秒杀商品生成订单
        List<SeckillGoods> seckillGoodsList = seckillGoodsService.getGoodsList();
        // 每一个用户都是从里面随机挑选一个商品购买
        SeckillGoods seckillGoods = seckillGoodsList.get(random.nextInt(seckillGoodsList.size()));
        String pid = seckillGoods.getPid();
        int userBurQty = random.nextInt(10);
        // 查询该商品消息
        SeckillGoods seckillGoodsInfo = null;
        try{
            lock.lock();
            seckillGoodsInfo = seckillGoodsService.getGoodsByPid(pid);
            if (userBurQty ==0){
                userBurQty = random.nextInt(10);
            }
            int qty = seckillGoodsInfo.getQty();
            if(qty<=0){
                return new ReturnMakeJson(2001,pid+"库存为"+qty+",请重新下单",null).result();
            }
            if (userBurQty>qty){
                return new ReturnMakeJson(2001,"库存不足,请重新下单",null).result();
            }
            // 下面就可以开始下单流程了
            SeckillOrders seckillOrders = new SeckillOrders();
            seckillOrders.setUid(uid);
            seckillOrders.setPname(seckillGoodsInfo.getPname());
            seckillOrders.setMoner(BigdecimalUtils.mul(seckillGoodsInfo.getPrice(),userBurQty));
            seckillOrders.setNumber(userBurQty);
            seckillOrders.setOid(IDUtils.getOid());
            seckillOrders.setPid(pid);
            seckillOrders.setCreatetime(sdf.format(new Date()));

            // 生成订单
            boolean flag = seckillGoodsService.saveSeckillOrders(seckillOrders,userBurQty,pid);
            if(flag){
                return new ReturnMakeJson(200,"订单生成success",seckillOrders.getOid()).result();
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            lock.unlock();
        }
        return new ReturnMakeJson(200,"订单生成失败",null).result();
    }
}
