package com.xin;

import java.util.Arrays;

public class DemoArrays {

    public static void main(String[] args) {
        // 按照格式打印数组元素 [元素1,元素2,元素3......]
        int[] arr = { 1, 2, 5, 9, 4, 3, 1, 7 };
        System.out.println(Arrays.toString(arr));

        // 升序排序
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        // 二分查找,只能升序数组使用
        int index = Arrays.binarySearch(arr, 5);
        System.out.println(index);

        // 数组扩容
        System.out.println("arr.length=" + arr.length);
        arr = Arrays.copyOf(arr, 10);
        System.out.println("扩容后arr.length=" + arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
