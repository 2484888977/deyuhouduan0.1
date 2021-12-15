package com.deyu.util;

import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilTools {

    /**
     * Spring提供的MD5加密方法
     * 将字符串转化为 32 位的MD5字符串
     * @param str 需要加密的字符串
     * @return String 加密后的MD5字符串
     */
    public static String Encrypted_MD5(String str){
        return DigestUtils.md5DigestAsHex(str.getBytes());
    }

    /**
     * 获取当前网络ip
     * @param request
     * @return
     */
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "UNKNOWN".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "UNKNOWN".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "UNKNOWN".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return "0:0:0:0:0:0:0:1".equals(ip) ? "127.0.0.1" : ip;
    }

    public static String getRemoteIP(HttpServletRequest request) {
        if (request.getHeader("x-forwarded-for") == null) {
            return request.getRemoteAddr();
        }
        return request.getHeader("x-forwarded-for");
    }

    /**
     * 给出时间，计算出当前时间距离现在还剩余多少天
     * 给出时间的格式为"yyyy-MM-dd HH:mm:ss"
     */
    public static int computingTime (String formatTime){
        long date_time_now = new Date().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = dateFormat.parse(formatTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long date_time = date.getTime();
        return (int) ((date_time-date_time_now)/1000/86400);
    }

    /**
     * 日期时间字符串转标准日期
     * 2021-08-15 00:00:00
     * 2021年08月15日
     */
    public static String dtToDate(String dateTime) {
        System.out.println(dateTime);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf1 = new SimpleDateFormat( "yyyy年MM月dd日" );
        Date date = null;
        try {
            date = sdf.parse(dateTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String str = sdf1.format(date);
        return str;
    }
}




