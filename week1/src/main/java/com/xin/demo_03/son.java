package com.xin.demo_03;

public class son extends father {
    String name = "son";

    son() {
        System.out.println("子类无参构造");
    }

    /*
     * @Override
     * protected void say() {
     * System.out.println("你好，我是子类");//不可，因为protected<public
     * }
     */
    @Override
    public void say() {
        System.out.println("你好，我是子类");
    }
}
