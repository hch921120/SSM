package com.itheima.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: Hch
 * @Date: 2019/3/1 11:12
 * @Description:
 */
public class DateUtils {

    //时间格式
    public  static SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public  static SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy年-MM月-dd日 ");
    public  static SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("yyyy/MM/dd ");
    public  static SimpleDateFormat simpleDateFormat4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /***
     * 时间格式转换
     * @param date
     * @return
     */
    public static String dateToStr(Date date,SimpleDateFormat simpleDateFormat){
        return simpleDateFormat.format(date);
    }


    public static void main(String[] args) {

        System.out.println(dateToStr(new Date(), DateUtils.simpleDateFormat4));







    }


}
