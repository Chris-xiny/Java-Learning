package com.Chrisxin.c_regex;

import java.util.Arrays;

public class Demo01Regex {
    public static void main(String[] args) {
        //字符类
        //method01();
        //逻辑运算符
        //method02();
        //预定义字符
        //method03();
        //数量词
        //method04();
        //分组括号
        //method05();
        //其他方法
        method06();

    }

    private static void method06() {
        //- `String[] split (String regex)`：根据给定正则表达式的匹配拆分此字符串。
        String[] array1="haha hehe   heihei".split(" +");
        System.out.println(Arrays.toString(array1));
        //- `String replaceAll (String regex, String replacement)`：把满足正则表达式的字符串，替换为新的字符。
        String s="haha hehe   heihei".replaceAll(" +","|");
        System.out.println(s);

    }

    private static void method05() {
        //检验"abc"可以一起出现无数次
        boolean result01 = "abcabc".matches("(abc)*");
        System.out.println(result01);
    }

    private static void method04() {
        //验证字符串是否是三个数字
        boolean result01 = "123".matches("\\d{3}");
        System.out.println(result01);
        //验证手机号,1开头，后一位3 5 8,剩余的数字0-9任意
        boolean result02 = "15847952486".matches("[1][358]\\d{9}");
        System.out.println(result02);
        //验证qq号,开头不能是0，其他都是数字，长度5-15
        boolean result03 = "123456789".matches("[1-9]\\d{5,15}");
        System.out.println(result03);
    }

    private static void method03() {
        //验证字符串是否是三个数字
        boolean result01 = "123".matches("\\d\\d\\d");
        System.out.println(result01);
        //验证字符串h开头,d结尾,中间是一个任意字符
        boolean result02 = "h1d".matches("[h].[d]");
        System.out.println(result02);
    }

    private static void method02() {
        //要求首字母是大写字母并且不能以aeiou开头,后面跟ad
        boolean result01 = "Cad".matches("[[A-Z]&&[^aeiou]][a][d]");
        System.out.println(result01);
        //开头是aeiou中的某一个字符,ad结尾
        boolean result02 = "aad".matches("[a|e|i|o|u][a][d]");
        System.out.println(result02);
    }

    private static void method01() {
        //判断字符串是否a开头,d结尾,中间aeiou中的某一个字符
        boolean result01 = "afd".matches("[a][aeiou][d]");
        System.out.println(result01);
        //判断字符串是否a开头,d结尾,中间不是aeiou中的某一个字符
        boolean result02 = "afd".matches("[a][^aeiou][d]");
        System.out.println(result02);
        //判断字符串开头是a-z，结尾是a和d
        boolean result03 = "aad".matches("[a-z][a][d]");
        System.out.println(result03);
    }
}
