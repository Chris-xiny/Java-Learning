package com.xin.a_File;

import java.io.File;

public class Method_Traversal {
    public static void main(String[] args) {
        //String[] list()                 :遍历指定文件夹,返回的是String数组
        File file=new File("E:\\Code\\Java\\Intern\\week8\\src\\main\\java\\com\\xin\\a_File\\test");
        String[] list=file.list();
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
        //File[] listFiles()              :遍历指定文件夹,返回的是File数组(这个推荐使用)
        File[] files=file.listFiles();
        for (File files1 : files) {
            System.out.println(files1);
        }
    }
}
