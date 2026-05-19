package com.xin.j_Commons_IO;

import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;

public class FileUtilsDemo {
    public static void main(String[] args) {
        /*
        FileInputStream fis=new FileInputStream("E:\\Code\\Java\\JavaBasic\\week8\\src\\main\\java\\com\\xin\\1.txt");
        FileOutputStream fos=new FileOutputStream("E:\\Code\\Java\\JavaBasic\\week8\\src\\main\\java\\com\\xin\\2.txt");
        IOUtils.copy(fis,fos);
        */
        FileInputStream fis=null;
        try{
            fis=new FileInputStream("E:\\Code\\Java\\JavaBasic\\week8\\src\\main\\java\\com\\xin\\1.txt");
        }catch (IOException e){
        e.printStackTrace();
    }finally {
            IOUtils.closeQuietly(fis);
        }
        }
}
