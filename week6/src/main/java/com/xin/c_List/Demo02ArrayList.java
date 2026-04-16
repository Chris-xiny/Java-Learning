package com.xin.c_List;

import java.util.ArrayList;
import java.util.Iterator;

public class Demo02ArrayList {
    public static void main(String[] args) {
        ArrayList<String> arraylist=new ArrayList<>();
        arraylist.add("Doctor");
        arraylist.add("凯尔西");
        arraylist.add("斯卡蒂");
        arraylist.add("史尔特尔");
        //遍历
        Iterator<String> iterator=arraylist.iterator();
        while(iterator.hasNext()){
            String element=iterator.next();
            System.out.println(element);
        }
        System.out.println("=======================================");
        for (int i = 0; i < arraylist.size(); i++) {
            System.out.println(arraylist.get(i));
        }
    }
}
