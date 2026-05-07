package com.xin.d_ResolveIOExp;

import java.io.FileWriter;
import java.io.IOException;

public class JDK7before {
    //JDK7及之前处理异常的方式
    public static void main(String[] args) {
        FileWriter fw=null;//2.但是作用域问题需要将fw的创建提出来而不是try里创建
        try{
            fw=new FileWriter("E:\\Code\\Java\\Intern\\week8\\src\\main\\java\\com\\xin\\1.txt",true);
            fw.write("\n处理异常成功");
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{//3.再try一次是因为close他也有自己的异常需要处理
                if(fw!=null){//4.fw对象new成功了才关闭流
                    fw.close();//1.不论如何都得关闭流因此放进finally块
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
