package com.xin.demo_05;

public interface USB {

    public static final int num = 100;

    public abstract void open();// 抽象方法必须重写

    public default void close() // 默认方法可重写可不重写
    {
        System.out.println("断开连接");
    }

    public static void methodSta() {
        System.out.println("我是静态方法");
    }

}
