package com.Chrisxin.d_MethodReference;

import java.util.function.Consumer;
import java.util.stream.Stream;

public class method01 {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("明日", "三上", "金莲", "松下", "有菜");
        /*
         * accept是重写方法:  参数类型为String
         *                   无返回值
         *
         * accept里由println方法:println参数也为String且被引用的方法(println)操作的是accept的参数
         *                      println也没有返回值
         *
         * 因此符合方法引用语法，可以在Lambda表达式的基础上再次简化
         */

        //原表达式
        /*stream.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });*/

        System.out.println("======================");
        //Lambda表达式
        //stream.forEach(s->System.out.println(s));
        System.out.println("======================");
        /*  方法引用再简化
            - 去掉Lambda表达式的参数和箭头 `->`
            - 去掉被引用方法的参数
            - 将方法调用的 `.` 替换为方法引用符 `::`
        */
        stream.forEach(System.out::println);

    }
}
