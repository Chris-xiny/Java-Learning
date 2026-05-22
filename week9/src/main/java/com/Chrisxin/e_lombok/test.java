package com.Chrisxin.e_lombok;

public class test {
    public static void main(String[] args) {
        //Set方法
       Person p1= new Person();
       p1.setAge(10);
       p1.setName("小王");
       //Get方法
        System.out.println(p1.getName()+"..."+p1.getAge());
        //有参
        Person p2= new Person("小赵",11);
        //toString
        System.out.println(p2);
        //无参
        Person p3= new Person();
        System.out.println(p3);
    }
}
