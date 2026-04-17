package com.xin.c_List;

import java.util.Iterator;
import java.util.LinkedList;

public class DemoLinkedList{
    public static void main(String[] args) {
        LinkedList<String> linkedlist=new LinkedList<>();
        linkedlist.add("Doctor");
        linkedlist.add("凯尔西");
        linkedlist.add("斯卡蒂");
        linkedlist.add("史尔特尔");
        System.out.println(linkedlist);
        //public void addFirst(E e):将指定元素插入此列表的开头。
        linkedlist.addFirst("幽灵鲨");
        System.out.println(linkedlist);
        //public void addLast(E e):将指定元素添加到此列表的结尾。
        linkedlist.addLast("魔王");
        System.out.println(linkedlist);
        //public E getFirst():返回此列表的第一个元素。
        System.out.println(linkedlist.getFirst());
        //public E getLast():返回此列表的最后一个元素。
        System.out.println(linkedlist.getLast());
        //public E removeFirst():移除并返回此列表的第一个元素。
        linkedlist.removeFirst();
        System.out.println(linkedlist);
        //public E removeLast():移除并返回此列表的最后一个元素。
        linkedlist.removeLast();
        System.out.println(linkedlist);
        //public E pop():从此列表所表示的堆栈处弹出一个元素。 底层直接return removeFirst();
        linkedlist.pop();
        System.out.println(linkedlist);
        //public void push(E e):将元素推入此列表所表示的堆栈。底层直接return addFirst();
        linkedlist.push("史尔特尔");
        System.out.println(linkedlist);
        //public boolean isEmpty():如果列表没有元素,则返回true.
        System.out.println(linkedlist.isEmpty());
        System.out.println("=================");
        Iterator<String> iterator=linkedlist.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("==========");
        for (String linkedlist2 : linkedlist) {
            System.out.println(linkedlist2);
        }
    }
}