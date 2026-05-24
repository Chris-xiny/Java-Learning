package com.Chrisxin.a_Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class DemoGetConstruction_Method {
    public static void main(String[] args) throws Exception {
        //获取class对象
        Class<Person> personClass = Person.class;
        //反射获取public无参构造
        Constructor<Person> pConstructor = personClass.getConstructor();

        //暴力反射：获取私有的有参构造
        Constructor<Person> pdConstructor = personClass.getDeclaredConstructor(String.class,Integer.class);

        //暴力反射：将该构造的私有属性解除
        pdConstructor.setAccessible(true);
        //利用无参构造new对象
        Person person = pConstructor.newInstance();
        //利用有参构造new对象
        Person person1 = pdConstructor.newInstance("柳岩",10);

        System.out.println(pConstructor);
        System.out.println(pdConstructor);
        System.out.println("=============操作前person与person1==============");
        System.out.println("person..."+person);
        System.out.println("person1..."+person1);

        System.out.println("===========================");
        //获取方法
        Method setName = personClass.getMethod("setName", String.class);
        Method getName = personClass.getMethod("getName");
        //利用该方法调用setName与getName,如果是私有方法的话还需在调用前将该方法的私有属性解除
        setName.invoke(person,"柳岩");
        Object name = getName.invoke(person);
        System.out.println("person...name="+name);

        System.out.println("===========================");
        //获取属性值
        Field i = personClass.getDeclaredField("i");
        //解除该属性的私有属性
        i.setAccessible(true);
        //设置与获取person的该属性的值
        i.set(person,10);
        Object o = i.get(person);
        System.out.println("person...i="+o);
        System.out.println("==========操作后person与person1============");
        System.out.println("person..."+person);
        System.out.println("person1..."+person1);

    }
}
