package com.xin;

public class synMethod01 implements Runnable {
    int ticket=100;
    Object syn=new Object();

    @Override
    public void run(){
        while(ticket!=0){
            try {
                Thread.sleep(10);
                synchronized(syn){//在run方法中直接使用同步代码块给代码加锁
                    if(ticket>0){
                        System.out.println(Thread.currentThread().getName()+"购买了第"+ticket+"张票");
                        ticket--;
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        synMethod01 myticket=new synMethod01();
        Thread t1=new Thread(myticket,"张三");
        Thread t2=new Thread(myticket,"李四");
        Thread t3=new Thread(myticket,"王五");
        t1.start();
        t2.start();
        t3.start();
    }
}
