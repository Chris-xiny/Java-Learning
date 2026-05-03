package com.xin.b_ByteStream;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStream01 {
    public static void main(String[] args) throws IOException{
        method01();
    }
    private static void method01() throws IOException{
        FileOutputStream fout=new FileOutputStream("src\\main\\java\\com\\xin\\b_ByteStream\\1.txt");
        // void write(int b)       一次写一个字节
        fout.write(97);            //97---ASCII:a
        // void write(byte[] b)   一次性将b数组写入 
        byte[] bytes={98,99,100};    //ASCII:bcd
        fout.write(bytes);                  
        // void write(byte[] b, int off,int len)   从b数组的off索引开始写len个
        byte[] bytes2={99,100,101,102,103,99};  //ASCII:cdefgc
        fout.write(bytes2,2,3);
        // void close()        关闭输出流
        fout.close();
    }
}
