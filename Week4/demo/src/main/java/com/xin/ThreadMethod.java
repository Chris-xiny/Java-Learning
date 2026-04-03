package com.xin;

public class ThreadMethod extends Thread{
    @Override
    public void run(){
        //获取线程名并遍历0-2
        for (int i = 0; i < 3; i++) {
            System.out.println(getName()+"执行了"+i);
            //执行一次就礼让CPU重新抢夺，尽量让其他线程有机会运行，尽量交替
            Thread.yield();
        }
        System.out.println(getName()+"结束");
    }
    public static void main(String[] args) throws InterruptedException {
        System.out.println("-----------------常用方法示例-----------------");
        ThreadMethod tm1=new ThreadMethod();
        ThreadMethod tm2=new ThreadMethod();
        //设置线程名
        tm1.setName("线程A");
        tm2.setName("线程B");
        //设置优先级
        tm1.setPriority(10);
        //测试守护线程，非守护线程结束后守护线程也会结束
        Thread2 t1=new Thread2();
        t1.setName("Daemon");
        t1.setDaemon(true);//设置为守护线程，可开关对比输出结果有何不同
        //开启线程
        tm1.start();
        tm2.start();
        t1.start();
        //将tm1、tm2插到主线程前，主线程会等他俩结束才继续执行
        tm1.join();
        tm2.join();

        //获取线程优先级
        System.out.println("线程A优先级为"+tm1.getPriority());
        System.out.println("线程B优先级为"+tm2.getPriority());
        //获取当前线程，即主线程main，再获取主线程名字
        System.out.println(Thread.currentThread().getName()+"完成");
    }
}

class Thread2 extends Thread{
    @Override
    public void run()
    {
        //让守护线程等待3s打印Daemon结束，但因为tm1、tm2、main线程都结束了，所以等不到3s也会提前结束，不会打印Daemon结束
        try{
            sleep(3000L);
            System.out.println(getName()+"结束");
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
