package com.xin.c_List;

import java.util.ArrayList;

public class Demo01ArrayList{
    public static void main(String[] args) {
        ArrayList<String> arraylist=new ArrayList<>();
        //boolean add(E e)                    将元素添加到集合的尾部(add方法一定能添加成功的，所以我们不用boo1ean接收返回值)
        arraylist.add("Doctor");
        arraylist.add("凯尔西");
        arraylist.add("斯卡蒂");
        arraylist.add("史尔特尔");
        System.out.println(arraylist);
        //void add(int index，E element)      在指定索引位置上添加元素
        arraylist.add(2,"幽灵鲨");
        System.out.println(arraylist);
        //boolean remove(object o)            删除指定的元素，删除成功为true，失败为false
        arraylist.remove("幽灵鲨");
        System.out.println(arraylist);
        //E remove(intindex)                  删除指定索引位置上的元素，返回的是被删除的那个元素
        String element=arraylist.remove(0);
        System.out.println(element);
        System.out.println(arraylist);
        //E set(int index，Eelement)          将指定索引位置上的元素，修改成后面的element元素
        element=arraylist.set(1,"幽灵鲨");
        System.out.println(element);
        System.out.println(arraylist);
        //E get(int index)                    根据索引获取元素
        element=arraylist.get(0);
        System.out.println(element);
        //int size()                          获取集合元素个数
        System.out.println(arraylist.size());
    }
}