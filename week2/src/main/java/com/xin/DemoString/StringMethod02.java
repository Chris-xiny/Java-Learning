package com.xin.DemoString;

import java.util.Scanner;

public class StringMethod02 {
    public static void main(String[] args) {
        // 练习String的转换方法
        // 判断一个字符串中大小写字母与数字对应的数量(A-Z:65-90 a-z:97-122 0-9:48-57)
        Scanner sc = new Scanner(System.in);
        int big = 0;
        int small = 0;
        int num = 0;
        String s = sc.next();
        char[] c = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (c[i] >= 'S' && c[i] <= 'Z') {
                big++;
            }
            if (c[i] >= 'a' && c[i] <= 'z') {
                small++;
            }
            if (c[i] >= '0' && c[i] <= '9') {
                num++;
            }
        }
        sc.close();
        System.out.println("大写字母数量:" + big);
        System.out.println("小写字母数量:" + small);
        System.out.println("数字数量:" + num);
    }
}