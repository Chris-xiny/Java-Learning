package com.xin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DemoSimpleDateFormat {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 指定日期输出格式
        String s = sdf.format(new Date());// 转为指定格式的字符串
        System.out.println(s);
        Date d = sdf.parse("2026-3-21 23:44:01");// 将符合指定格式的字符串转为date类对象,注意要处理异常ParseException
        System.out.println(d);
    }
}
