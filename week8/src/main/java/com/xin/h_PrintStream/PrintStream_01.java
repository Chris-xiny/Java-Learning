package com.xin.h_PrintStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Date;

public class PrintStream_01 {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream ps = new PrintStream(
                new FileOutputStream("week8//src//main//java//com//xin/h_PrintStream//log.txt", true));
        ps.println(new Date() + "日志报告:发生错误1");
        ps.print(new Date() + "日志报告:发生错误2");
        ps.print("\n");
        System.out.println(new Date() + "日志报告:发生错误3");
        System.setOut(ps);//改变流向到log.txt
        System.out.println(new Date() + "日志报告:发生错误4");
        ps.close();
    }
}
