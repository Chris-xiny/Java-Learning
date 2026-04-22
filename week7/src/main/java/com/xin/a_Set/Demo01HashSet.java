package com.xin.a_Set;

import java.util.HashSet;
import java.util.Iterator;

public class Demo01HashSet {
    public static void main(String[] args) {
        HashSet<String> hashSet=new HashSet<>();
        hashSet.add("张三");
        hashSet.add("李四");
        hashSet.add("王五");
        hashSet.add("张三");//元素唯一
        System.out.println(hashSet);//存取顺序不一样，元素无序

        //迭代器
        Iterator<String> it=hashSet.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("================================");
        //增强for
        for (String hashSet2 : hashSet) {
            System.out.println(hashSet2);
        }
    }   
}