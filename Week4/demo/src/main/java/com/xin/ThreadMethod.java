package com.xin;

public class ThreadMethod extends Thread{
    @Override
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println(getName()+"执行了"+i);
        }
    }
    public static void main(String[] args) {
        ThreadMethod tm1=new ThreadMethod();
        ThreadMethod tm2=new ThreadMethod();
        tm1.setName("线程A");
        tm2.setName("线程B");
        tm1.start();
        tm2.start();
    }
}
