package com.xin.MultiThread;

public class Producer implements Runnable{
    private BaoziShop bzs;
    public Producer(BaoziShop bzs){
        this.bzs=bzs;
    }
    @Override
    public void run(){
        while(true){//持续做包子
            try {
                Thread.sleep(1000);//让程序不那么快
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            bzs.setCount();
        }
    }
}
