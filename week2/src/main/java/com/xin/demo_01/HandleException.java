package com.xin.demo_01;

import java.io.FileNotFoundException;

public class HandleException {
    public static void main(String[] args) {
        String s = "abc.md";
        // 先演示try_catch处理异常，因为无论有无异常都不会影响后面的代码执行
        findcatch(s);
        // 再演示向上抛出异常，最后因为没人处理jvm会打印异常信息后退出程序，出现异常之后的代码将无法执行
        findthrow(s);
        /*
         * 运行后结果为findcatch异常信息打印后，继续完成输出“执行findcatch”，直到findthrow异常信息往上抛无人处理而被迫终止程序，
         * 因此“执行findcatch”没有输出.
         */
    }

    // 1.向上抛出异常交给上面处理
    public static void findthrow(String s) throws NullPointerException {
        if (!s.endsWith(".txt")) {
            throw new NullPointerException();
        }
        System.out.println("执行findthrow");
    }

    // 2.不向上抛出，try_catch自己处理
    public static void findcatch(String s) {
        try {
            if (!s.endsWith(".txt")) {
                throw new FileNotFoundException();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            System.out.println("--------------------------------");// 无论有没有异常finally中的代码都会在方法结束前执行
        }
        System.out.println("执行findcatch");
    }
}
