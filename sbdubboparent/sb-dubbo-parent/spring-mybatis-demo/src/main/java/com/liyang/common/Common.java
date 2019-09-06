package com.liyang.common;

import org.junit.Test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Common {
    @Test
    public static Date getBrithday(){
        Date date = new Date();//获得系统时间.
        String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);//将时间格式转换成符合Timestamp要求的格式.
        Timestamp newdate = Timestamp.valueOf(nowTime);//把时间转换
        System.out.println(newdate);
        return newdate;
    }
}
