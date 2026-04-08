package com.xin.demo_01;

public class demo {

    public static void main(String args[]) {
        phone p = new phone();// 创建对象来完成自己想用的功能
        p.init();// 初始化手机
        p.call("Cris");// 打电话给某人，我们直接使用该对象包含的方法即可而不需关心他如何实现
    }
}
