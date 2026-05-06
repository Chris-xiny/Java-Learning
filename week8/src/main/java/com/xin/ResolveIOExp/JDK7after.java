package com.xin.ResolveIOExp;

import java.io.FileWriter;
import java.io.IOException;

public class JDK7after {
    public static void main(String[] args) {
        try(FileWriter fw=new FileWriter("E:\\Code\\Java\\Intern\\week8\\src\\main\\java\\com\\xin\\1.txt",true);){
            fw.write("\n处理异常成功");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
