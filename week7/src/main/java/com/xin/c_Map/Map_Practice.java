package com.xin.c_Map;

import java.util.HashMap;
import java.util.Scanner;

public class Map_Practice{
    public static void main(String[] args) {
        //Map集合练习一:输入字符串，统计字符串包含字符数量
        //1.创建Scanner输入字符串
        Scanner sc =new Scanner(System.in);
        String data=sc.next();
        sc.close();
        char[] ch=data.toCharArray();
        HashMap<String,Integer> map=new HashMap<>();
        for (char c : ch) {
            String k=c+" ";
            if(!map.containsKey(k)){

                map.put(k,1);
            }else{
                Integer i=map.get(k)+1;
                map.put(k,i);
            }
        }
        System.out.println(map);
    }
}