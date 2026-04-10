package com.xin.MultiThread;

public class BaoziShop {
    private int count;//包子
    private boolean flag;//是否有包子
    public BaoziShop(int count,boolean flag){
        this.count=count;
        this.flag=flag;
    }
    public synchronized void getCount() {
        if(flag==false){//如果没包子，线程等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //否则有包子，开始吃
        System.out.println("吃掉了第"+count+"个包子");
        //改变flag为false，表示没包子了
        flag=false;
        //唤醒生产者包包子
        notify();
    }

    public synchronized void setCount() {
        if(flag==true){//如果有包子，线程等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //否则没有包子，开始制作
        count++;
        //改变flag为true，表示有包子了
        flag=true;
        //唤醒消费者吃包子
        notify();
        System.out.println("生产了第"+count+"个包子");
    }
    
    public boolean isFlag() {
        return flag;
    }
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    
}
