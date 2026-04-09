package com.xin.MultiThread;

public class BaoziShop {
    private int count;//包子
    private boolean flag;//是否有包子
    public BaoziShop(int count,boolean flag){
        this.count=count;
        this.flag=flag;
    }
    public void getCount() {
        System.out.println("吃掉了第"+count+"个包子");
    }
    public void setCount() {
        count++;
        System.out.println("生产了第"+count+"个包子");
    }
    public boolean isFlag() {
        return flag;
    }
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    
}
