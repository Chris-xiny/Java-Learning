package com.xin;

public class DemoThread extends Thread{//第一种创建线程方法--继承Thread
    @Override
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println("第一种方法创建的子线程遍历......"+i);
        }
    }
    public static void main(String[] args) {
        //创建线程对象
        DemoThread dt=new DemoThread();
        //调用start方法，开启线程，jvm自动调用run方法
        dt.start();

        //第二种方法创建线程
        RunnableThread rt=new RunnableThread();
        Thread t=new Thread(rt);
        t.start();

        //第三种方法创建线程--匿名内部类创建线程
        new Thread(new Runnable(){
            @Override
            public void run(){
                for (int i = 0; i < 5; i++) {
                    System.out.println("第三种方法创建的子线程遍历......"+i);
            }
            }
        }).start();
        
        //与主线程抢占
        for (int i = 0; i <5; i++) {
            System.out.println("main线程......"+i);
        }
    }
}

class RunnableThread implements Runnable{//第二种创建线程方法--实现Runnable接口

    @Override
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println("第二种方法创建的子线程遍历......"+i);
    }
}
}
