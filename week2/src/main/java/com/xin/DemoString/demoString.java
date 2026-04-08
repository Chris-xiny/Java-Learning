package com.xin.DemoString;

public class demoString {
    public static void main(String[] args) {
        // 1.String无参构造
        String s = new String();
        System.out.println(s);
        // 2.根据字符串创建新的字符串
        s = new String("abc2");
        System.out.println(s);
        // 3.根据char数组创建新的字符串
        char[] c = { 'a', 'b', 'c', '3' };
        s = new String(c);
        System.out.println(s);
        // 4.通过使用平台的默认字符集解码指定的byte数组，构造一个新的String
        byte[] bytes = { -28, -67, -96 };
        s = new String(bytes);
        System.out.println(s);
        // 5.简化型
        s = "abc5";
        System.out.println(s);
    }
}
