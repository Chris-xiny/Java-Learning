package com.Chrisxin.d_MethodReference;

import java.util.function.Supplier;

public class method02 {
    public static void main(String[] args) {
        /*
            * get无参数，返回值为String
            * trim无参数，返回值也为String
            * 可以考虑使用方法引用
        */
        /*method(new Supplier<String>() {
            @Override
            public String get() {
                return " haha  ".trim();
            }
        });*/
        System.out.println("==================");
        //method(()->" haha  ".trim());
        System.out.println("===================");
        method(" haha  "::trim);
    }

    private static void method(Supplier<String> supplier) {
        String s=supplier.get();
        System.out.println(s);
    }
}
