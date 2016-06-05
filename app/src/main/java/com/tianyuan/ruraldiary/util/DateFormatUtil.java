package com.tianyuan.ruraldiary.util;

/**
 *日期格式处理工具类
 */
public class  DateFormatUtil {
    /**
     * 月份常量
     */
    private static final String MONTHS[]={
            "January",
            "February",
            "March",
            "April",
            "May",
            "June",
            "July",
            "August",
            "September",
            "October",
            "November",
            "December"};
    private static final String MONTHSNUMBER[]={"01","02","03","04","05","06","07",
    "08","09","10","11","12"};

    /**
     * 获取格式化后的日期格式
     * @param dateText 数据库中存储的日期，以"-"划分
     * @return 返回处理后的日期格式
     */
    public static String getFormatDate(String dateText){
        String year="0000";
        String month="00";
        String day="00";
        String[] splitDate=null;
        splitDate=splitDate(dateText);

        for (int i=0;i<splitDate.length;i++){
            year=splitDate[0];
            month=splitDate[1];
            day=splitDate[2];
        }
        return showData(year,setMonthFormat(month),day);

    }

    /**
     * @param dateText
     * @return
     */
    private static String[] splitDate(String dateText){
        String strDate[]=dateText.split("-");
        return strDate;
    }

    /**
     * 设置月份格式
     * @param month
     * @return
     */
    private static String setMonthFormat(String month){
        String nowMonth=null;
        for (int i=0;i<MONTHSNUMBER.length;i++){
            if (month.equals(MONTHSNUMBER[i])){
                nowMonth=MONTHS[i];
                break;
            }
        }
        return nowMonth;

    }

    /**
     * 返回拼接后的日期格式
     * @param year
     * @param month
     * @param day
     * @return
     */
    private static String showData(String year,String month,String day){
        return month+" "+day+","+year;
    }

}
