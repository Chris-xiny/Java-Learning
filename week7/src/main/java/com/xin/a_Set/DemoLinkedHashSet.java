package com.xin.a_Set;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class DemoLinkedHashSet {
    public static void main(String[] args) {
        LinkedHashSet<String> hashSet=new LinkedHashSet<>();
        hashSet.add("张三");
        hashSet.add("李四");
        hashSet.add("王五");
        hashSet.add("张三");//元素唯一
        System.out.println(hashSet);//元素有序

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
