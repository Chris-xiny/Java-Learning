package com.xin.g_ThreadPool;

public class MyRunnable implements Runnable {
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName());
    }

}
