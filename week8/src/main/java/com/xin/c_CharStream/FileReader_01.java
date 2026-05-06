package com.xin.c_CharStream;

import java.io.FileReader;
import java.io.IOException;

public class FileReader_01 {
    public static void main(String[] args) throws IOException {
        method01();
    }

    private static void method01() throws IOException{
        FileReader fr1=new FileReader("E:\\Code\\Java\\Intern\\week8\\src\\main\\java\\com\\xin\\1.txt");
        //int read(int b)       一次读一个字符,返回的是读取的字符对应ASCII;文件到达了末尾,返回-1
        int len;
        while((len=fr1.read())!=-1){
            System.out.print((char)len);
        }
        fr1.close();

        System.out.println("========================");
        //int read(char[] cbuf)   一次性读取一个字符数组,返回的是读取的字符个数 ，到达文件末尾依旧返回-1
        FileReader fr2=new FileReader("E:\\Code\\Java\\Intern\\week8\\src\\main\\java\\com\\xin\\1.txt");
        char[] chars=new char[2];
        while(fr2.read(chars)!=-1){
            System.out.print(chars);
        }
        fr2.close();
    }
}
