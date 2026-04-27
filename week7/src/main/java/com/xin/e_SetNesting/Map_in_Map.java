package com.xin.e_SetNesting;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class Map_in_Map {
    /* 
    需求:
        JavaSE 班级 Map
        键（学号） → 值（姓名）
            1 → 张三
            2 → 李四

        JavaEE 班级 Map
        键（学号） → 值（姓名）
            1 → 王五
            2 → 赵六
    */
   public static void main(String[] args) {
    HashMap<Integer,String> class1=new HashMap<>();
        class1.put(1,"张三");
        class1.put(2,"李四");
        HashMap<Integer,String> class2=new HashMap<>();
        class2.put(1,"王五");
        class2.put(2,"赵六");

        HashMap<String,HashMap<Integer,String>> map=new HashMap<>();
        map.put("JavaSE",class1);
        map.put("JavaEE",class2);
        //其中一种遍历方法
        Set<Map.Entry<String,HashMap<Integer,String>>> set=map.entrySet();//获取第一层map的键值对set
        for (Entry<String,HashMap<Integer,String>> entry : set) {//遍历map的键值对Entry,key为班级名(String),value为班级(HashMap<Integer,String>)
            Set<Entry<Integer,String>> e=entry.getValue().entrySet();//将第一层每个键值对的值取出并再次获取键值对entry
            for (Entry<Integer,String> element : e) {//遍历第二层map的键值对，key为学号(Integer),value为姓名(String)
                System.out.println(element.getKey()+"......"+element.getValue());//获取键与值输出
            }
        }
   }
    
}
