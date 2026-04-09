package com.xin.MultiThread;

public class test {
    public static void main(String[] args) {
        BaoziShop bzs =new BaoziShop(0, false);
        Producer p=new Producer(bzs);
        Consumer c=new Consumer(bzs);
    
        Thread t1=new Thread(p);
        Thread t2=new Thread(c);
        t1.start();
        t2.start();
    }
    

}
