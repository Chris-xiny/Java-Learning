package com.Chrisxin.b_FunctionalInterface;

public class test01 {
    public static void main(String[] args) {
        method01("鼠标", d->System.out.println(d+"已连接"));
    }

    public static void method01(String s,USB usb) {
        usb.connect(s);
    }

}
