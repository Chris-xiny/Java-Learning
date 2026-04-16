package com.xin.b_Iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class DemoIterator {
    public static void main(String[] args) {
        ArrayList<String> list=new ArrayList<>();
        list.add("Doctor");
        list.add("凯尔西");
        list.add("斯卡蒂");
        list.add("史尔特尔");
        //获取迭代器对象
        Iterator<String> iterator=list.iterator();
        //获取下一个对象   小细节:最好不要同时next多个元素，除非保证每个next都有检查过hasNext,不然可能超出集合范围
        while(iterator.hasNext()){
            String element=iterator.next();
            System.out.println(element);
            if("史尔特尔".equals(element)){
                //list.add("巴别塔"); //导致并发修改异常
            }
        }
    }
}
