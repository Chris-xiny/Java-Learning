package com.xin.a_Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class CollectionDemo {
    public static void main(String[] args) {
        Collection<String> c1=new ArrayList<>();
        //boolean add(E e):将给定元素添加到集合中
        c1.add("Doctor");
        c1.add("凯尔西");
        c1.add("斯卡蒂");
        c1.add("史尔特尔");
        System.out.println(c1);
        //boolean addAll(Collection<? extends E> c):将另一个集合添加到当前集合
        Collection<String> c2=new ArrayList<>();
        c2.add("巴别塔");
        c1.addAll(c2);
        System.out.println(c1);
        //boolean remove(Object o):将指定元素从当前集合移除
        c1.remove("巴别塔");
        System.out.println(c1);
        //boolean contains(Object o):判断当前集合是否包含指定元素
        System.out.println("Is c1 contains 巴别塔?......"+c1.contains("巴别塔"));
        //int size():返回集合中元素的个数
        System.out.println("c1.size="+c1.size());
        //Object[] toArray():把集合中的元素存储到数组中
        Object[] arr =c1.toArray();
        System.out.println(Arrays.toString(arr));
        //void clead():清除集合中的元素
        c1.clear();
        System.out.println(c1);
        //boolean isEmpty():判断当前集合是否为空
        System.out.println("Is c1 empty?......"+c1.isEmpty());
    }   
    

}
