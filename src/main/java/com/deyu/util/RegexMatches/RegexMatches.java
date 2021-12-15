package com.deyu.util.RegexMatches;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches {
    //手机号验证——0?(13|14|15|18|17)[0-9]{9}
    public static boolean PhonenumberVerify(String str){
        String pattern = "0?(13|14|15|18|17)[0-9]{9}";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        return m.matches();
    }
    //邮箱验证——\w[-\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\.)+[A-Za-z]{2,14}
    public static boolean EmailVerify(String str){
        String pattern = "\\w[-\\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\\.)+[A-Za-z]{2,14}";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        return m.matches();
    }
    //qq验证——
    public static boolean QqVerify(String str){
        String pattern = "[1-9]([0-9]{4,10})";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        return m.matches();
    }
    //vx验证——
    public static boolean VxVerify(String str){
        String pattern = "^[a-zA-Z]{1}[-_a-zA-Z0-9]{5,19}+$";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        return m.matches();
    }
    //身份证验证——\d{17}[\d|x]|\d{15}
    public static boolean ProidVerify(String str){
        String pattern = "\\d{17}[\\d|x]|\\d{15}";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        return m.matches();
    }

    //学号位数验证——\d{10}
    public static boolean XuehaoVerify(String str){
        String pattern = "[1-2]0?(17|18|19|20|21)(01|02|03|04|05|06|07|08|09)[0-9]{5}";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        return m.matches();
    }

    //验证全汉字——[\u4e00-\u9fa5]
    public static boolean ChineseVerify(String str,int start, int end){
        String pattern = "[\\u4e00-\\u9fa5]";
        int count = 0;
        Pattern r = Pattern.compile(pattern);
        char c[] = str.toCharArray();
        for (char value : c) {
            Matcher m = r.matcher(String.valueOf(value));
            if(m.matches()){
                count++;
            }else {
                return false;
            }
        }
        return count>=start&&count<=end ? true : false;
    }
    //7-10数验证——^\d{7,10}$
    public static boolean BnajiVerify(String str){
        String pattern = "^\\d{7,}$";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        return m.matches();
    }

    //学生床位格式验证——[0-9]{4,5}-[1-8]
    public static boolean ChuangweiVerify(String str){
        String pattern = "[0-9]{4,5}-[1-8]";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        return m.matches();
    }
}
