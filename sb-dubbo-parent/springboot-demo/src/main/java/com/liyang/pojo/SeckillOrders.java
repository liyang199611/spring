package com.liyang.pojo;

import java.io.Serializable;
import java.util.Date;

// 秒杀订单
public class SeckillOrders implements Serializable {
    private String oid; // 订单id
    private String uid; // 下单用户id
    private String pid; // 下单商品编码
    private String pname; // 商品名称
    private int number; // 下单商品数量
    private double moner ;// 下单金额
    private String createtime; // 下单时间

    public String getPid() {
        return pid;
    }

    public String getPname() {
        return pname;
    }


    public String getUid() {
        return uid;
    }

    public int getNumber() {
        return number;
    }

    public double getMoner() {
        return moner;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setMoner(double moner) {
        this.moner = moner;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }
}
