package com.xin.g_ThreadPool;

import java.util.concurrent.Callable;

public class MyStringCallable implements Callable<String>{
    @Override
    public String call() throws Exception{
        return "1-100的总和为:";
    }
}
