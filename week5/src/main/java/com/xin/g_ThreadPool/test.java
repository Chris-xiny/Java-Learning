package com.xin.g_ThreadPool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class test {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //创建线程池对象,测试执行Runnable任务
        ExecutorService es1=Executors.newFixedThreadPool(2);
        //提交三个线程任务
        es1.submit(new MyRunnable());
        es1.submit(new MyRunnable());
        es1.submit(new MyRunnable());
        //关闭线程池对象,如果不关闭程序不会结束，因为线程池会一直等待新任务
        es1.shutdown();
        //创建线程池对象,测试执行Runnable任务
        ExecutorService es2=Executors.newFixedThreadPool(2);
        /*
            Callable的call()有返回值，可以用Future对象接收，再通过它的get()方法获取线程任务的返回值
            练习一个线程输出字符串,一个线程计算返回1-100的总和
        */
        Future<Integer> Intfuture=es2.submit(new MyIntegerCallable());
        Future<String> Stringfuture=es2.submit(new MyStringCallable());
        System.out.println(Stringfuture.get()+Intfuture.get());
        es2.shutdown();
    }
}
