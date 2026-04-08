package com.xin.demo_05;

public class charger implements USB {
    @Override
    public void open() {
        System.out.println("开始充电");
    }
}
