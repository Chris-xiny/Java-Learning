package com.Chrisxin.d_MethodReference;

import java.util.function.Supplier;

public class method03 {
    public static void main(String[] args) {
        /*
         * get无参数，返回值为Double
         * Math.random()无参数，返回值也为Double
         * 可以考虑使用方法引用(类名引用静态方法)
         */

        /*method(new Supplier<Double>() {
            @Override
            public Double get() {
                return Math.random();
            }
        });*/

        //method(()->Math.random());
        System.out.println("================");
        method(Math::random);
    }

    private static void method(Supplier<Double> supplier) {
        System.out.println(supplier.get());
    }
}
