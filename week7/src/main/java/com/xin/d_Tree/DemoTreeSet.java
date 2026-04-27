package com.xin.d_Tree;

import java.util.Comparator;
import java.util.TreeSet;

public class DemoTreeSet{
    public static void main(String[] args) {
        //构造一个新的空Set,该Set根据元素的自然顺序进行排序--ASCII
        TreeSet<String> set=new TreeSet<>();
        set.add("c.白毛浮绿水");
        set.add("a.鹅鹅鹅");
        set.add("d.红掌拨清波");
        set.add("b.曲项向天歌");
        System.out.println(set);
        System.out.println("==============================");
        //当元素为自定义类型，要指定排序方法,否则会报错
        TreeSet<Person> set1=new TreeSet<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1,Person o2){
                return o2.getAge()-o1.getAge();
            }
        });
        set1.add(new Person("史尔特尔",30));
        set1.add(new Person("凯尔希",3000));
        set1.add(new Person("魔王",200));
        System.out.println(set1);
    }
}