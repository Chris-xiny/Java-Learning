package com.xin.b_hashCode;

import java.util.HashSet;

public class test2 {
    public static void main(String[] args) {
        HashSet<Person2> set=new HashSet<>();
        set.add(new Person2("张三",18));//哈希值不同，存
        set.add(new Person2("李四",20));//哈希值不同，存
        set.add(new Person2("张三",18));//哈希值相同，不存
        System.out.println(set);
    }
}
