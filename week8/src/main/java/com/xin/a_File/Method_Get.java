package com.xin.a_File;

import java.io.File;

public class Method_Get {
    public static void main(String[] args) {
        System.out.println("==============================");
        // String getAbsolutePath()    :获取File的绝对路径(带盘符的路径) 
        File file1=new File("Note.md");
        System.out.println(file1.getAbsolutePath());//如果没有盘符(E:\\),他会在前面直接加上当前project的绝对路径
        System.out.println("==============================");
        // String getPath()            :获取的是封装路径(new对象写的啥路径就是什么路径)
        System.out.println(file1.getPath());
        System.out.println("==============================");
        // String getName()            :获取的是文件或文件夹的名称
        File file3=new File("E:\\Code\\Java\\Intern\\week8\\Note.md");
        System.out.println(file3.getName());
        System.out.println("==============================");
        // long length()               :获取的是文件的长度(文件的字节数)
        File file4=new File("E:\\Code\\Java\\Intern\\week8\\src\\main\\java\\com\\xin\\a_File\\test_5.txt");
        System.out.println(file4.length());
    }
}
