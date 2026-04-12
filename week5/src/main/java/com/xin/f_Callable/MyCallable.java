package com.xin.f_Callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception{

        return "你好";
    }
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        MyCallable mycallable=new MyCallable();
        //创建FutureTask类接受call()返回值
        FutureTask<String> futureTask=new FutureTask<>(mycallable);
        //用Thread(Runnable target)创建Thread对象......因为FutureTask接口实现了RunnableFuture接口，而RunnableFuture实现了Runnable;
        new Thread(futureTask).start();
        //调用get方法获取call的返回值
        System.out.println(futureTask.get());//有异常需要处理可以直接抛
    }
}
