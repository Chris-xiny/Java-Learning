package com.xin.a_File;

import java.io.File;

public class Practice {
    public static void main(String[] args) {
        //a.创建File对象,指定要遍历的文件夹
        File file=new File("E:\\Code\\Java\\Intern\\week8\\src\\main\\java\\com\\xin\\a_File\\test");
        method(file);
    }
    private static void method(File file){
        //b.调用listFiles(),遍历文件夹,返回File数组
        File[] files=file.listFiles();
        for (File files1 : files) {//c.遍历File数组,在遍历过程中判断,如果是文件,获取文件名,判断是否以.jpg结尾的,如果是则输出
            if(files1.isFile()){
                String name=files1.getName();
                if(name.endsWith(".jpg")){
                    System.out.println(name);
                }
            }else{//d.否则是文件夹,递归重复2 3 4步骤.
                method(files1);
            }
        }
        
    }
}
