package com.Chrisxin.b_FunctionalInterface;

import java.util.Arrays;
import java.util.function.Supplier;

public class DemoSupplier {
    public static void main(String[] args) {
        method(new Supplier<Integer>() {
            @Override
            public Integer get() {
                int[] arr = {0, 5, 2, 4, 6, 7, 2, 0};
                Arrays.sort(arr);
                return arr[arr.length - 1];
            }
        });

        System.out.println("==============");

        method(() -> {
            {
                int[] arr = {0, 5, 2, 4, 6, 7, 2, 0};
                Arrays.sort(arr);
                return arr[arr.length - 1];
            }
        });
    }

    public static void method(Supplier<Integer> s) {
        Integer i = s.get();
        System.out.println(i);
    }
}

