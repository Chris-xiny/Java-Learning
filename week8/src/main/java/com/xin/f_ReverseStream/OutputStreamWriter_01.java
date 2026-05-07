package com.xin.f_ReverseStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class OutputStreamWriter_01 {
    public static void main(String[] args) throws IOException {
        OutputStreamWriter osw=new
                OutputStreamWriter(new FileOutputStream("week8//src//main//java//com//xin//1.txt",true),"gbk");
        osw.write("\n你好");//用gbk编码写入，打开1.txt时默认utf-8打开看到"你好"变成了乱码
        osw.close();
    }
}
