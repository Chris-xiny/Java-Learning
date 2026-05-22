package com.Chrisxin.d_MethodReference;

import java.util.function.Function;

public class method04 {
    public static void main(String[] args) {
        /*
         * apply参数为String，返回值为Person
         * 构造方法Person参数也为String，返回值也为Person
         * 可以考虑使用方法引用(构造引用)
         */

        /*method(new Function<String, Person>() {
            @Override
            public Person apply(String s) {
                return new Person(s);
            }
        },"涛哥");*/
        System.out.println("=================");
        //method(s->new Person(s),"涛哥");
        method(Person::new,"涛哥");
    }

    private static void method(Function<String,Person> function,String name) {
        Person p=function.apply(name);
        System.out.println(p);
    }
}
