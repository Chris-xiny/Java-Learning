package com.xin.b_hashCode;

public class test1 {
    public static void main(String[] args) {
        Person1 p1=new Person1("张三",18);
        Person1 p2=new Person1("张三",18);
        //没有重写toString()方法，输出对象地址值(哈希值的十六进制)
        System.out.println(p1);//com.xin.b_hashCode.Person@5305068a         
        System.out.println(p2);//com.xin.b_hashCode.Person@1f32e575         
        //没有重写hashCode()，默认计算对象的哈希值,若重写了就是对象内容的哈希值,前者p1p2哈希值不相等，后者相等
        System.out.println(Integer.toHexString(p1.hashCode()));//重写前:5305068a     重写后:16e8e0a
        System.out.println(Integer.toHexString(p2.hashCode()));//重写前:1f32e575     重写后:16e8e0a
        
        //但是，尽管内容不一样，哈希值有可能不一样
        String s1="通话";
        String s2="重地";
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
    }
    
}
