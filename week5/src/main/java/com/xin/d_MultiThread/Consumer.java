package com.xin.d_MultiThread;

public class Consumer implements Runnable {
    private BaoziShop bzs;
    public Consumer(BaoziShop bzs){
        this.bzs=bzs;
    }
    @Override
    public void run(){
        while(true){//持续吃包子
            try {
                Thread.sleep(1000);//让程序不那么快
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            bzs.getCount();
        }
    }
}
