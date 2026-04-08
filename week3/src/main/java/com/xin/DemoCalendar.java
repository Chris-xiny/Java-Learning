package com.xin;

import java.util.Calendar;
import java.util.Date;

public class DemoCalendar {

    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        System.out.println(c);

        System.out.println(c.get(Calendar.YEAR));

        c.set(Calendar.YEAR, 2025);
        System.out.println(c.get(Calendar.YEAR));

        c.set(2024, 2, 1);// month=2代表三月，国外从0算起

        c.add(Calendar.DATE, -1);// 3月1日减一天为2月29或28日
        System.out.println(c.get(Calendar.YEAR));

        int day = c.get(Calendar.DATE);
        if (day == 29) {
            System.out.println("2024年是闰年");
        } else {
            System.out.println("2024年是平年");
        }
        Date date = c.getTime();
        System.out.println(date);

    }
}
