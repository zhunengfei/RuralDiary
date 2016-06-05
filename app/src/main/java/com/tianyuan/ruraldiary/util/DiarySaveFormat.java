package com.tianyuan.ruraldiary.util;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 存储时获取时间并格式化
 */
public class DiarySaveFormat {

    /**
     * 返回处理后的时间格式
     * @return
     */
    public static String formatWeekStr(){
            long time = System.currentTimeMillis();
            Date date = new Date(time);
            //时间
            String dateFormat = new SimpleDateFormat("HH:mm").format(date);
            //星期
            SimpleDateFormat format=new SimpleDateFormat("EEEE");
            String week = format.format(date);
            //格式化
        Log.d("week",week);
            return week+"-"+dateFormat;
        }

    /**
     * 返回创建日记
     * @return
     */
    public static String formatTimeStr(){
        long time = System.currentTimeMillis();
        Date date = new Date(time);
        String monthday=new SimpleDateFormat("yyyy-MM-dd").format(date);
        return monthday;
    }


}
