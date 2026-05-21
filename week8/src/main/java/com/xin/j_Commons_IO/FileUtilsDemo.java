package com.xin.j_Commons_IO;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileUtilsDemo {
    public static void main(String[] args) throws IOException {
       /* - **静态方法：`FileUtils.copyDirectoryToDirectory(File src, File dest);`**
                传递 `File` 类型的目录，进行整个目录的复制，自动进行递归遍历。
                - 参数：
                - `src`: 要复制的文件夹路径
                        - `dest`: 要将文件夹粘贴到哪里去*/

        //FileUtils.copyDirectoryToDirectory(new File(""),new File(""));

        /* - **静态方法：`writeStringToFile(File file, String str)`**
                写字符串到文本文件中。
        */
        //FileUtils.writeStringToFile(new File("E:\\Code\\Java\\JavaBasic\\week8\\src\\main\\java\\com\\xin\\1.txt"), "hello world");
     /*
         - **静态方法：`String readFileToString(File file)`**
         读取文本文件，返回字符串。
     */
        String str = FileUtils.readFileToString(new File("E:\\Code\\Java\\JavaBasic\\week8\\src\\main\\java\\com\\xin\\1.txt"));
        System.out.println(str);
    }
}
