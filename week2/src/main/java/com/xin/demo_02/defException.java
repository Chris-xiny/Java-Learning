package com.xin.demo_02;

import java.util.Scanner;

public class defException {
    public static void main(String[] args) {
        String username = "root";
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入登陆的用户名");
        String name = sc.next();
        if (name.equals(username)) {
            System.out.println("登陆成功");
        } else {
            try {
                throw new LoginUserException("用户名输入错误");
            } catch (Exception e) {
                // System.out.println(e.toString());
                e.printStackTrace();
            } finally {
                sc.close();
            }
        }
        sc.close();
    }

}