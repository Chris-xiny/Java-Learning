package com.xin.d_Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class DemoCollections {
    public static void main(String[] args) {
        LinkedList<String> list=new LinkedList<>();
        // static <T> bollean addAll()(Collection<? super T> c, T... elements)     批量添加元素
        Collections.addAll(list,"Doctor","史尔特尔","斯卡蒂","幽灵鲨");
        System.out.println(list);
        // static void shuffle(List<?> list)       将集合中的元素打乱
        Collections.shuffle(list); 
        System.out.println(list);
        // static <T> void sort(List<T> list)      将集合中的元素按照默认规则排序->按照第一个字符的ASXII码表
        ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add("c.举头望明月");
        arrayList.add("b.疑是地上霜");
        arrayList.add("d.低头思故乡");
        arrayList.add("a.床前明月光");
        Collections.sort(arrayList);
        System.out.println(arrayList);
        System.out.println("============================================");
        // static <T> void sort(List<T> list,Comparator<? super T> c)      将集合中的元素按照指定规则排序
        ArrayList<Person> personList=new ArrayList<>();
        personList.add(new Person("张三",18));
        personList.add(new Person("李四",17));
        personList.add(new Person("王五",19));
        //方法一匿名内部类创建比较器定义比较方法排序
        Collections.sort(personList,new Comparator<Person>() {
            @Override//重写compare自定义比较方法
            public int compare(Person o1,Person o2){
                return o1.getAge()-o2.getAge();//前减后升序
            }
        });
        System.out.println(personList);
        System.out.println("===========");
        //方法2重写Comparable接口实现compareTo方法
        ArrayList<Person> personList2=new ArrayList<>();
        personList2.add(new Person("张三",18));
        personList2.add(new Person("李四",17));
        personList2.add(new Person("王五",19));
        Collections.sort(personList);
        System.out.println(personList);
        System.out.println("============================================");
        //扩展Arrays中的一个静态方法static <T> List<T> asList(T...a)   可直接将指定元素转存到list集合中
        List<String> list2=Arrays.asList("张三","李四","王五");
        System.out.println(list2);
    }
}
