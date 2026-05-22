package com.Chrisxin.a_Lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Demo01Lambda {

    public static void main(String[] args) {
        //Lambda表达式示例
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("新线程启动了");
            }
        }).start();
        System.out.println("============================");
        new Thread(()->System.out.println("新线程启动了")).start();
        System.out.println("============================");

        ArrayList<Person> list1 =new ArrayList<>();
        list1.add(new Person("张三", 18));
        list1.add(new Person("李四", 20));
        list1.add(new Person("王五", 21));
        ArrayList<Person> list2 =new ArrayList<>();
        list2.add(new Person("张三", 18));
        list2.add(new Person("李四", 20));
        list2.add(new Person("王五", 21));
        //匿名内部类写Comparator比较器
        list1.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge()-o2.getAge();
            }
        });
        //Lambda表达式写Comparetor匿名内部类(最简化)
        Collections.sort(list2,(o1,o2)->o1.getAge()-o2.getAge());

        System.out.println(list1);
        System.out.println("============================");
        System.out.println(list2);
    }

}
