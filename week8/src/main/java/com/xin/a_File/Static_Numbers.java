package com.xin.a_File;

import java.io.File;

public class Static_Numbers {
    public static void main(String[] args) {
        //static String pathSeparator:与系统有关的路径分隔符,为了方便,他被表示为一个字符串    ;
        System.out.println(File.pathSeparator);
        //static String Separator:与系统有关的默认名称分隔符,为了方便,他被表示为一个字符串    \ 
        System.out.println(File.separator);
    }

    
}
