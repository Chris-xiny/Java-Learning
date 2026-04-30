package com.xin.a_File;

import java.io.File;

public class Method_Judge{
    public static void main(String[] args) {
        // boolean isDirectory()           :判断是否为文件夹
        File file=new File("E:\\Code\\Java\\Intern\\week8\\src\\main\\java\\com\\xin\\a_File\\test_5.txt");
        System.out.println(file.isDirectory());
        // boolean isFile()                :判断是否为文件
        System.out.println(file.isFile());
        // boolean exists()                :判断文件或文件夹是否存在 
        System.out.println(file.exists());
    }
}