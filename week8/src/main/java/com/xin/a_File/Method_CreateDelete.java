package com.xin.a_File;

import java.io.File;
import java.io.IOException;

public class Method_CreateDelete {
    public static void main(String[] args) throws IOException {
        /* boolean createNewFile()     :创建文件
                如果要创建的文件之前有,创建失败,返回false
                如果要创建的文件之前没有,创建成功,返回true*/
        File file1=new File("E:\\Code\\Java\\Intern\\week8\\src\\main\\java\\com\\xin\\a_File\\2.txt");
        System.out.println(file1.createNewFile());
        /*boolean mkdirs()             :创建文件夹(目录)既可以创建多级文件夹,还可以创建单级文件夹
                如果要创建的文件夹之前有,创建失败,返回false
                如果要创建的文件夹之前没有,创建成功,返回true */
        File file2=new File("E:\\Code\\Java\\Intern\\week8\\src\\main\\java\\com\\xin\\a_File\\test\\test2");
        System.out.println(file2.mkdirs());
        //boolean delete()                :删除文件或文件夹
        File file3=new File("E:\\Code\\Java\\Intern\\week8\\src\\main\\java\\com\\xin\\a_File\\2.txt");
        System.out.println(file3.delete());
    }
}
