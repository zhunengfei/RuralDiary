package com.tianyuan.ruraldiary.util;

/**
 * 星期&&时间格式处理
 */
public class WeekFormatUtil {
    /**
     * 格式处理后
     *
     */
    private static final String WEEK[]={
            "Monday",
            "Tuesday",
            "Wednesday",
            "Thursday",
            "Friday",
            "Saturday",
            "Sunday"};
    /**
     * 格式处理前
     */
    private static final String WEEKNUMBER[]={
            "星期一",
            "星期二",
            "星期三",
            "星期四",
            "星期五",
            "星期六",
            "星期天"};

    /**
     * 返回格式化后的week和Time
     * @param diaryWeek
     * @return
     */
    public static String getFormatWeekAndTime(String diaryWeek){
        String formatWeek="";
        String week="星期N";
        String time="00:00";
        //拆分
        String str[]=diaryWeek.split("-");
        //取值
        week=str[0];
        time=str[1];
        //转换
        for (int i=0;i<WEEKNUMBER.length;i++){
            if (week.equals(WEEKNUMBER[i])||week.equals(WEEK[i])){
                formatWeek=WEEK[i];
                break;
            }
        }

        return formatWeek+" "+time;
    }

}
