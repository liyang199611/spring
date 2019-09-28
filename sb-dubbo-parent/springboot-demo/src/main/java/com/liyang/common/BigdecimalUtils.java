package com.liyang.common;

import java.math.BigDecimal;

public class BigdecimalUtils {

    public static double add(double v1,double v2){
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return Double.parseDouble(b1.add(b2).toString());
    }

    public  static double sub(double v1,double v2){
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return Double.parseDouble(b1.subtract(b2).toString());
    }

    public  static double mul(double v1,double v2){
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return Double.parseDouble(b1.multiply(b2).toString());
    }

    public static double div(double v1,double v2){
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return Double.parseDouble(b1.divide(b2).toString());
    }
}
