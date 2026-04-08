package com.xin.demo_03;

public class father {
    String name = "father";

    father() {
        System.out.println("父类无参构造");
    }

    public void say() {
        System.out.println("你好，我是父类");
    }

    public static void main(String[] args) {
        father fa = new son();// 左边是父类，所以同名变量是父类的
        System.out.println("--------------------------");
        System.out.println(fa.name);
        System.out.println("--------------------------");
        fa = new son();// 右边是子类，所以同名方法是子类
        System.out.println("--------------------------");
        fa.say();
    }
}