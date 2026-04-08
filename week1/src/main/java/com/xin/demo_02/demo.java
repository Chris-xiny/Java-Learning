package com.xin.demo_02;

public class demo {
    public static void main(String[] args) {
        Citizen p1 = new Citizen();
        p1.name = "大卫";
        p1.birthday = new MyDate(2000, 2, 31);
        p1.idCard = "1992599";
        System.out.println(p1.name + " " + p1.idCard + " " + p1.birthday.year);
    }

}
