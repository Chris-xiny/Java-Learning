package com.Chrisxin.d_design.TemplateMethod;

public abstract class Hotel {
    public void toLunch(){
        System.out.println("点菜");
        eat();
        System.out.println("买单");
    }
    public abstract void eat();
}
