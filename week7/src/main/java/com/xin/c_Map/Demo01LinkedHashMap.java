package com.xin.c_Map;

import java.util.LinkedHashMap;

public class Demo01LinkedHashMap {
    public static void main(String[] args) {
        LinkedHashMap<String,String> map=new LinkedHashMap<>();
        map.put("唐僧", "女儿国国王");
        map.put("至尊宝", "紫霞");
        map.put("至尊宝", "白晶晶");
        map.put("后羿", "嫦娥");
        System.out.println(map);
    }
}
