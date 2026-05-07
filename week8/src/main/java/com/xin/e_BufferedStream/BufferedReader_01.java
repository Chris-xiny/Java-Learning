package com.xin.e_BufferedStream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReader_01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new FileReader("week8//src//main//java//com//xin//1.txt"));
        String line;
        while((line=br.readLine())!=null){
            System.out.println(line);
        }
        br.close();
    }
}
