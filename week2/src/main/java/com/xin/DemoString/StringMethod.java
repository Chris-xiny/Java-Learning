package com.xin.DemoString;

import java.util.Scanner;

//演示String的equals方法与它的equalsIgnoreCase方法，后者比较忽略大小写
public class StringMethod {
    public static void main(String[] args) {
        final String username = "Xin";
        final String password = "abc123456";
        String uname;
        String pwd;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名:");
        uname = sc.next();
        System.out.println("请输入密码:");
        pwd = sc.next();
        if (uname.equalsIgnoreCase(username) && pwd.equals(password)) {
            System.out.println("登陆成功!");
        } else {
            System.out.println("登陆失败,用户名或密码错误!");
        }
        sc.close();
    }
}
