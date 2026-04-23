package com.xin.c_Map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Demo01HashMap{
    public static void main(String[] args) {
        // put(K key，V value)->添加元素，返回的是被覆盖的value
        HashMap<String,String> hashMap=new HashMap<>();
        String value1=hashMap.put("猪八", "嫦娥");
        System.out.println(value1);
        String value2=hashMap.put("猪八", "高翠兰");
        System.out.println(value2);
        System.out.println(hashMap);

        hashMap.put("唐僧", "女儿国国王");
        hashMap.put("后羿", "嫦娥");
        hashMap.put("二郎神", "嫦娥");
        hashMap.put(null, null);
        System.out.println(hashMap);
        // V remove(Object key) ->根据key删除键值对，返回的是被删除的value
        String value3=hashMap.remove("猪八");
        System.out.println(value3);
        System.out.println(hashMap);
        // V get(Object key)-> 根据key获取value
        String value4=hashMap.get("唐僧");
        System.out.println(value4);
        // boolean containsKey(Object key)-> 判断集合中是否包含指定的key
        System.out.println(hashMap.containsKey("二郎神"));
        // Collection<V> values() -> 获取集合中所有的value,转存到col1ection集合中
        Collection<String> collection=hashMap.values();
        System.out.println(collection);
        System.out.println("===============================");
        //遍历方式1: Set<K> keySet()->将Map中的key获取出来，转存到Set集合中
        Set<String> set=hashMap.keySet();
        for (String key : set) {
            //根据key获取value
            System.out.println(key+"..."+hashMap.get(key));
        }
        System.out.println("===============================");
        //遍历方式2: Set<Map.Entry<K,V>>entrySet()->获取Map集合中的键值对，转存到set集合中
        Set<Map.Entry<String,String>> set1=hashMap.entrySet();
        for(Map.Entry<String,String> entey:set1){
            System.out.println("key."+entey.getKey()+"---value."+entey.getValue());
        }
    }
}