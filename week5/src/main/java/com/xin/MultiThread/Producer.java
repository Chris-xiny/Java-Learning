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
                Thread.sleep(100);//让程序不那么快
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized(bzs){
                if(bzs.isFlag()==true){//如果有包子，线程等待
                    try {
                        bzs.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //否则没有包子，开始制作
                bzs.setCount();
                //改变flag为true，表示有包子了
                bzs.setFlag(true);
                //唤醒消费者吃包子
                bzs.notify();
            }
        }
    }
}
