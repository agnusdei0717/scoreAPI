package com.bofa.payment.scoreAPI.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateUtil {
    private static Log log = LogFactory.getLog(DateUtil.class);

    public static String formatDate(){
        return formatDate("yyyy-MM-dd");
    }

    public static String formatDate(String style){
        SimpleDateFormat sdf = new SimpleDateFormat(style);
        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        try {
            String dateStr = sdf.format(new Date());
            return dateStr;
        }catch(Exception e){
            log.info(e.toString());
            return null;
        }
    }

    public static Date parseStringToDate(String dateStr){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        try {
            Date d = sdf.parse(dateStr);
            return d;
        }catch(Exception e){
            log.info(e.toString());
            return null;
        }
    }

    public static String getDateFormateStr(String need){

        String dateStr = formatDate("yyyyMMdd");
        if(need.equals("year")) {
            dateStr = dateStr.substring(0, 4);
        }else if(need.equals("month")){
            String day = dateStr.substring(6, 8);
            dateStr = dateStr.substring(4, 6);
            if(Integer.parseInt(day) > 25){
                dateStr = String.valueOf(Integer.parseInt(dateStr)+1);
                if(Integer.parseInt(dateStr) > 12)
                    dateStr = "1";
            }
            if(Integer.parseInt(dateStr) < 10)
                dateStr = dateStr.replace("0","");
        }else{
            dateStr = dateStr.substring(6, 8);
            if(Integer.parseInt(dateStr) < 10)
                dateStr = dateStr.replace("0","");
        }

        return dateStr;
    }
}
