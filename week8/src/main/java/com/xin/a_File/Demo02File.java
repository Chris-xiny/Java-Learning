package com.xin.a_File;

import java.io.File;

public class Demo02File {
    public static void main(String[] args) {
    // File(String parent,String child)    根据所填写的路径创建File对象
    //parent:父路径   child:子路径
        File file1=new File("E:\\Code\\Java","Intern");
        System.out.println(file1);
    //File(File parent,String child)      根据所填写的路径创建File对象
    //parent:父路径,是一个File对象    child:子路径
        File file2=new File(file1,"Note.md");
        System.out.println(file2);
    //File(String pathname)      根据所填写的路径创建File对象
    //pathname:直接指定路径
        File file3=new File("E:\\Code\\Java\\Intern\\Note.md");
        System.out.println(file3);
    }
}
