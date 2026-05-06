package com.xin.c_CharStream;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriter_01 {
    public static void main(String[] args) throws IOException {
        FileWriter fw=new FileWriter("E:\\Code\\Java\\Intern\\week8\\src\\main\\java\\com\\xin\\1.txt",true);
        fw.write("\n我在追加字符");
        //fw.flush();
        fw.close();
    }
}
