package com.xin.MultiThread;

public class Consumer implements Runnable {
    private BaoziShop bzs;
    public Consumer(BaoziShop bzs){
        this.bzs=bzs;
    }
    @Override
    public void run(){
        while(true){//持续吃包子
            try {
                Thread.sleep(100);//让程序不那么快
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized(bzs){
                if(bzs.isFlag()==false){//如果没包子，线程等待
                    try {
                        bzs.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //否则有包子，开始吃
                bzs.getCount();
                //改变flag为false，表示没包子了
                bzs.setFlag(true);
                //唤醒生产者包包子
                bzs.notify();
            }
        }
    }
}
