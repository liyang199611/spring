package com.liyang.common;

import java.util.UUID;

public class IDUtils {
    public static String [] goodsNames = {
            "长寿花玉米油5.48L(C)",
            "高乐高卷卷心草莓味112g",
            "奥妙全自动无磷洗衣粉1700g",
            "乐事促销装104g*3(Z)",
            "顺美全角度马桶刷(Z)",
            "威猛洁厕柑橘清香900G",
            "双益臻品精圆面500G(Z)",
            "奥利奥巧心结浓情巧克力味47g",
            "七度空间少女系列纯棉日用卫生巾28片",
            "双汇鸡肉肠225g",
            "厨邦纯米醋420ml",
            "晨光乡土鸡蛋9枚",
            "口水娃烤肉味兰花豆86g(Z)",
            "伊脆番茄味薯条15g",
            "思念手打天下猪肉香菇水饺720g(Z)",
            "洽洽喀吱脆珍品原味薯片51g",
            "森和园雪丽糍葡萄100g",
            "VW1009维达卫生湿巾独立装10片",
            "杜家庄盐焗鸡腿80G(Z)",
            "青蛙王子防蛀儿童牙膏50g",
            "伊利每益添活性乳酸菌百香果100ml*5(Z)"
    };
    public static String getOid(){
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if(hashCodeV < 0) {//有可能是负数
            hashCodeV = - hashCodeV;
        }
        return String.format(1+"%015d", hashCodeV);
    }

    public static String getPid(){
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if(hashCodeV < 0) {//有可能是负数
            hashCodeV = - hashCodeV;
        }
        return String.format(1+"%015d", hashCodeV);
    }
}
