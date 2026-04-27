package com.xin.d_Tree;

import java.util.Comparator;
import java.util.TreeMap;

public class DemoTreeMap {
    public static void main(String[] args) {
        //构造一个新的空map1,该map1根据元素的自然顺序进行排序--ASCII
        TreeMap<String,String> map1=new TreeMap<>();
        map1.put("c","白毛浮绿水");
        map1.put("a","鹅鹅鹅");
        map1.put("d","红掌拨清波");
        map1.put("b","曲项向天歌");
        System.out.println(map1);
        System.out.println("==============================");
        //当元素为自定义类型，要指定排序方法,否则会报错
        TreeMap<Person,String> map2=new TreeMap<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1,Person o2){
                return o2.getAge()-o1.getAge();
            }
        });
        map2.put(new Person("史尔特尔",30),"女");
        map2.put(new Person("凯尔希",3000),"女");
        map2.put(new Person("魔王",200),"女");
        System.out.println(map2);
}
}
