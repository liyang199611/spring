package com.liyang.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 秒杀商品
 */
public class SeckillGoods implements Serializable {
    private String pid; // 商品id
    private String pname; // sp名称
    private double price; // 商品价格
    private int qty; // 商品库存
    public String getPname() {
        return pname;
    }

    public double getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    public String getPid() {
        return pid;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
}
