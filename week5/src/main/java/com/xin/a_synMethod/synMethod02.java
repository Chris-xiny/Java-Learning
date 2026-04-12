package com.xin.a_synMethod;

public class synMethod02 implements Runnable {
    int ticket=100;
    Object syn=new Object();

    @Override
    public void run(){
        while(ticket!=0){
            try {
                Thread.sleep(10);
                buyTicket();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public synchronized void buyTicket(){//创建非静态同步方法给不安全代码加锁
        if(ticket>0){
            System.out.println(Thread.currentThread().getName()+"购买了第"+ticket+"张票");
            ticket--;
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
