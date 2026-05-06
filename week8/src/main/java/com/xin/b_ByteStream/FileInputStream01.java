package com.xin.b_ByteStream;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStream01 {
    public static void main(String[] args) throws IOException {
        method01();
    }
    private static void method01() throws IOException {
        //int read(int b)一次读一个字节,返回的是读取的字节
        System.out.println("===int read(int b)一次读一个字节,返回的是读取的字节===");
        FileInputStream fin1=new FileInputStream("E:\\Code\\Java\\Intern\\week8\\src\\main\\java\\com\\xin\\1.txt");
        int date;
        while((date=fin1.read())!=-1){//当读完后在读取值为-1
            System.out.print((char)date);
        }


        //int read(byte[] b)   一次性读取一个数组,返回的是读取的字节个数
        System.out.println("\n===int read(byte[] b)一次性读取一个数组,返回的是读取的字节个数===");
        FileInputStream fin2=new FileInputStream("E:\\Code\\Java\\Intern\\week8\\src\\main\\java\\com\\xin\\1.txt");
        byte[] bytes1=new byte[3];//相当于缓存,一次读取两字节
        while((date=fin2.read(bytes1))!=-1){//date为读取的字节数,到达文件末尾依旧返回-1
            System.out.println(date+new String(bytes1,0,date));//利用String的一个构造方法,从byte数组的0处开始读取date个字节
        }


        //int read(byte[] b, int off,int len)   从b数组的off索引开始读len个,返回的是读取的字节个数
        //void close()        关闭输入流
        fin1.close();
        fin2.close();
    }
}
