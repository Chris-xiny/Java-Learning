package com.xin.b_ByteStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Practice {
    public static void main(String[] args) throws IOException {
        System.out.println("请输入待复制文件路径");
        Scanner sc=new Scanner(System.in);
        String copyPath=sc.next();
        System.out.println("请输入粘贴地址");
        String pastePath=sc.next();
        FileInputStream fin=new FileInputStream(copyPath);
        FileOutputStream fout=new FileOutputStream(pastePath,true);
        int len;
        byte[] bytes=new byte[1024];
        while((len=fin.read(bytes))!=-1){
            fout.write(bytes,0,len);

        }
    }
}
