package com.xin.demo_05;

public class test {
    public static void main(String[] args) {
        charger c = new charger();
        c.open();
        c.close();// 不重写也可使用默认方法
        USB.methodSta();
        System.out.println(USB.num);
    }
}
