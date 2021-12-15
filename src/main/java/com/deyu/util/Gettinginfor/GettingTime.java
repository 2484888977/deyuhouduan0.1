package com.deyu.util.Gettinginfor;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GettingTime {
    public static String GettingTime(){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(date);
    };
}
