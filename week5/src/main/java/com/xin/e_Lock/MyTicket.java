package com.xin.e_Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyTicket implements Runnable {
    int ticket=100;
    Lock lock=new ReentrantLock();

    @Override
    public void run(){
        while(ticket!=0){
            try {
                Thread.sleep(10);
                 //获取锁
                lock.lock();
                if(ticket>0){
                    System.out.println(Thread.currentThread().getName()+"购买了第"+ticket+"张票");
                    ticket--;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }finally{
                //无论有无异常都得释放锁，放在finally
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        MyTicket myticket=new MyTicket();
        Thread t1=new Thread(myticket,"张三");
        Thread t2=new Thread(myticket,"李四");
        Thread t3=new Thread(myticket,"王五");
        t1.start();
        t2.start();
        t3.start();
}
}
