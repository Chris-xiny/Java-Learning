package com.xin.e_SetNesting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Map_in_List {
    public static void main(String[] args) {
        //a班级有第三名同学，学号和姓名分别为：1=张三，2=李四，3=王五，b班有三名同学，学号和姓名分别为：1=黄晓明，2=杨颖，3=刘德华，
        //请将同学的信息以键值对的形式存储到2个Map集合中，在将2个Map集合存储到List集合中
        HashMap<Integer,String> class1=new HashMap<>();
        class1.put(1,"张三");
        class1.put(2,"李四");
        class1.put(3,"王五");
        HashMap<Integer,String> class2=new HashMap<>();
        class2.put(1,"小王");
        class2.put(2,"小张");
        class2.put(3,"小李");
        //将map集合存储到list中
        ArrayList<HashMap<Integer,String>> list=new ArrayList<>();
        list.add(class1);
        list.add(class2);
        //遍历一
        for (HashMap<Integer,String> map : list) {
            Set<Integer> set=map.keySet();
            for (Integer key : set) {
                System.out.println(key+"..."+map.get(key));
            }
        }
        System.out.println("=====================");
        //遍历二
        for (HashMap<Integer,String> map : list) {
            Set<Map.Entry<Integer,String>> set=map.entrySet();
            for (Map.Entry<Integer,String> entry : set) {
                System.out.println(entry.getKey()+"..."+entry.getValue());
            }
        }
    }
}
