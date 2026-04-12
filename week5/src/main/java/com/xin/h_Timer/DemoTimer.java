package com.xin.h_Timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class DemoTimer {
    public static void main(String[] args) {
        Timer timer=new Timer();
        timer.schedule(new TimerTask() {//用匿名类去实现线程任务
            @Override
            public void run(){
                System.out.println("我每隔2000ms执行一次哟");
            }
        }, new Date(), 2000);//new Date()创建现在的时间对象,从现在起每隔2s执行一次线程任务
    }
}
