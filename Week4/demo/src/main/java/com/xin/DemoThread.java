package com.xin;

public class DemoThread extends Thread{
    @Override
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println("子线程......"+i);
        }
    }
    public static void main(String[] args) {
        //创建线程对象
        DemoThread dt=new DemoThread();
        //调用start方法，开启线程，jvm自动调用run方法
        dt.start();

        //与主线程抢占
        for (int i = 0; i <5; i++) {
            System.out.println("main线程......"+i);
        }
    }
}
