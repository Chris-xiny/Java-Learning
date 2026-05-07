package com.xin.f_ReverseStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReader_01 {
    public static void main(String[] args) throws IOException {//用gbk会乱码，因为1.txt是utf-8编码
        InputStreamReader isr=new
                InputStreamReader(new FileInputStream("week8//src//main//java//com//xin//1.txt"),"gbk");
        int data;
        while((data=isr.read())!=-1){
            System.out.print((char)data);
        }
        isr.close();
    }
}
