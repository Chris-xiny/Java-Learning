package com.xin;

import java.lang.StringBuilder;
import java.util.Scanner;

public class StringBuilderDemo {
    public static void main(String[] args) {
        String s = "你";
        StringBuilder sb = new StringBuilder(s);// String转StringBuilder
        System.out.println("StringBuilder:" + sb);
        sb.append("好");
        StringBuilder sb1 = sb.append("66");
        System.out.println(sb1 == sb);// 地址值相等，没有创建新对象
        sb.append("77").append("88").append("99");// append返回StringBuilder对象，因此可以链式调用
        System.out.println("StringBuilder:" + sb);
        sb.reverse();// 反转
        System.out.println("StringBuilder:" + sb);
        s = sb.toString();// 将StringBuilder转为String类型
        System.out.println("String:" + s);
        System.out.println("======================");
        // 判断字符串是否为回文
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder(sc.next());
        if (sb.toString().equals(sb.reverse().toString())) {// 直接转为String用equals()与反转后转为String比较内容是否相等
            System.out.println("是回文");
        } else {
            System.out.println("反转后" + sb + "不是回文");
        }
        //sc.close();
    }
}