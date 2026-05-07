package com.xin.e_BufferedStream;

import java.io.*;

public class BufferedIOStream_01 {
    public static void main(String[] args) throws IOException {//通过复制同一文件对比基本流与缓冲流的读写速度
        method01();//基本流
        //method02();//缓冲流
    }

    private static void method01() throws IOException {
        FileOutputStream fout=new FileOutputStream("E:\\Code\\Java\\Intern\\week8\\src\\main\\java\\com\\xin\\2.txt");
        FileInputStream fin=new FileInputStream("E:\\Code\\Java\\Intern\\week8\\src\\main\\java\\com\\xin\\1.txt");
        int len;
        long start=System.currentTimeMillis();
        while((len=fin.read())!=-1){
            fout.write(len);
        }
        long end=System.currentTimeMillis();
        System.out.println(end-start);
        fout.close();
        fin.close();
    }
    private static void method02() throws IOException {
        FileOutputStream fout=new FileOutputStream("E:\\Code\\Java\\Intern\\week8\\src\\main\\java\\com\\xin\\2.txt");
        FileInputStream fin=new FileInputStream("E:\\Code\\Java\\Intern\\week8\\src\\main\\java\\com\\xin\\1.txt");
        BufferedOutputStream bout=new BufferedOutputStream(fout);
        BufferedInputStream bin=new BufferedInputStream(fin);
        int len;
        long start=System.currentTimeMillis();
        while((len=bin.read())!=-1){
            bout.write(len);
        }
        long end=System.currentTimeMillis();
        System.out.println(end-start);
        bout.close();
        bin.close();
    }
}
