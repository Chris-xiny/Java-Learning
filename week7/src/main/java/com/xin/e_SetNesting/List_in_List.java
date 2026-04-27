package com.xin.e_SetNesting;

import java.util.ArrayList;

public class List_in_List {
    public static void main(String[] args) {
        //创建两个List集合,每个集合中分别存储一些字符串,将两个集合存储到第三个集合中
        ArrayList<String> list1=new ArrayList<>();
        list1.add("史尔特尔");
        list1.add("斯卡蒂");
        ArrayList<String> list2=new ArrayList<>();
        list2.add("魔王");
        list2.add("凯尔希");
        //list存储两个ArrayList<String>类型,泛型应是ArrayList<String>
        ArrayList<ArrayList<String>> list=new ArrayList<>();
        list.add(list1);
        list.add(list2);
        //类似于二维数组
        System.out.println(list);
        //遍历
        for (ArrayList<String> arrayList : list) {
            for (String l : arrayList) {
                System.out.println(l);
            }
        }
    }
}
