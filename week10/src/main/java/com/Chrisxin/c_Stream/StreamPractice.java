package com.Chrisxin.c_Stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamPractice {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();
        //调用addAll方法创建队伍1
        Collections.addAll(list1, "赵六", "张三丰", "洪七公", "李四", "王五", "王阳明", "迪丽热巴", "苏星河", "老子");
        Stream<String> stream1 = list1.stream();
        System.out.println(list1);
        //调用Stream的of方法创建队伍2
        Stream<String> stream2 = Stream.of("古力娜扎", "宋远桥", "张无忌", "张三丰", "庄子", "张师傅");
        //将流保存到list复用,需要时可以list.stream创建流
        List<String> list2 = stream2.toList();
        System.out.println(list2);
        stream2 = list2.stream();

        /*  创建匿名内部类方式
            1.  第一个队伍：筛选名字为3个字的成员姓名；
            2.  第一个队伍：筛选后只保留前3个人
        */
        Stream<String> newStream1 = stream1.filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length() == 3;
            }
        }).limit(3);

        /*  使用Lambda表达式简化方式
            3.  第二个队伍：筛选姓“张”的成员姓名；
            4.  第二个队伍：筛选后跳过前2个人；
        */
        Stream<String> newStream2 = stream2.filter(s -> s.startsWith("张")).skip(2);
        /*
             5.  将两个队伍的流合并为一个；
             6.  遍历并打印合并后队伍的所有成员姓名。
         */
        Stream.concat(newStream1, newStream2).forEach(s -> System.out.println(s));
    }
}
