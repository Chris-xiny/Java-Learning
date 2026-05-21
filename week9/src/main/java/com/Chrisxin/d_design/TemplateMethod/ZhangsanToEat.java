package com.Chrisxin.d_design.TemplateMethod;

public class ZhangsanToEat extends Hotel{
    @Override
    public void eat() {
        System.out.println("吃麻辣烫");
        System.out.println("选菜");
        System.out.println("调麻酱");
        System.out.println("拌匀");
        System.out.println("吃好了");
    }
}
