package com.xin.demo_04;

public abstract class animals {
    int age;

    animals(int a) {
        age = a;// 父类仅显式定义了有参构造，所以没有无参构造，子类需显式调用super(参数)
    }

    public abstract void yell();// 父类定义的抽象方法，子类需要实现父类所有的抽象方法
}
