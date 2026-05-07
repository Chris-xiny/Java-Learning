package com.xin.e_BufferedStream;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriter_01 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw=new BufferedWriter(new FileWriter("week8//src//main//java//com//xin//1.txt",true));
        bw.newLine();
        bw.write("测试BufferedWriter的newLine方法");//不添加换行符
        bw.close();
    }
}
