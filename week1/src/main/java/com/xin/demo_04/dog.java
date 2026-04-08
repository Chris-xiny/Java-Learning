package com.xin.demo_04;

public class dog extends animals {

    dog(int a) {
        super(a);// 显式调用父类有参构造
    }

    @Override
    public void yell() {
        System.out.println("I'm " + super.age + ".......汪汪汪");
    }
}
