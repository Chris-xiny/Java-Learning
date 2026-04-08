package com.xin;

import java.util.Date;

public class DemoDate {
    public static void main(String[] args) {
        // 无参构造
        Date date = new Date();
        System.out.println(date);
        // 有参构造
        date = new Date(1000);
        System.out.println(date);
        // 设置时间
        date.setTime(2000);
        System.out.println(date);
        // 获取时间,得到毫秒值
        System.out.println(date.getTime());

    }
}
