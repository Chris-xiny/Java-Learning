package com.Chrisxin.d_MethodReference;

import java.util.function.Function;

public class method05 {
    /*  数组引用
     * apply参数为:Integer,返回值为int[]
     * new int[]可以看成是*int[] arr =new int[Integer],参数是Integer,返回值是int[]
     * 可以考虑使用方法引用(数组引用)
     */

    public static void main(String[] args) {
        /*method(new Function<Integer, int[]>() {
            @Override
            public int[] apply(Integer integer) {
                return new int[integer];
            }
        }, 10);*/

        System.out.println("==================");
        //method((i)->new int[i],10);
        method(int[]::new,10);
    }


    private static void method(Function<Integer, int[]> function, Integer len) {
        int[] arr = function.apply(len);
        System.out.println(arr.length);
    }
}
