package com.xin.c_Map;

import java.util.HashMap;

public class test {
    public static void main(String[] args) {
        HashMap<Person,String> map=new HashMap<>();
        map.put(new Person("涛哥",18),"河北省");
        map.put(new Person("涛哥",18),"海南省");//自定义类Person没有重写hashCode与equals方法，不能去重保证键唯一
        map.put(new Person("熊大",16),"狗熊岭");
        System.out.println(map);

        System.out.println("=========================");

        HashMap<Person1,String> map1=new HashMap<>();
        map1.put(new Person1("涛哥",18),"河北省");
        map1.put(new Person1("涛哥",18),"海南省");//自定义类Person1重写了hashCode与equals方法，能去重保证键唯一
        map1.put(new Person1("熊大",16),"狗熊岭");
        System.out.println(map1);
    }
}
