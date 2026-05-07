package com.xin.g_SerializationStream;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Serializable_01 {
    public static void main(String[] args) throws Exception {
        Hero p1=new Hero(100,"亚瑟","男");
        Hero p2=new Hero(100,"后羿","男");
        Hero p3=new Hero(100,"安其拉","女");
        ArrayList<Hero> heroes=new ArrayList<>();
        Collections.addAll(heroes,p1,p2,p3);

        //write(heroes);//由于没有追加续写功能，一次直接传入多个英雄对象
        read();//属性sex被transient修饰，不会参与到序列化当中,因此为null
    }
//反序列化流
    private static void read() throws Exception {
        ObjectInputStream ois=new ObjectInputStream
                (new FileInputStream("week8//src//main//java//com//xin//g_SerializationStream//hero.txt"));
        //这种方法在不确定对象数量无法使用,因此可以考虑直接序列化一个集合，于是反序列化一个集合就可以取出所有对象
        /*
        for (int i = 0; i < 3; i++) {
            System.out.println((Hero)ois.readObject());
        }
        */

        //直接反序列化一个集合就可以取出所有对象
        ArrayList<Hero> heroes=(ArrayList<Hero>) ois.readObject();
        for (Hero hero : heroes) {
            System.out.println(hero);
        }
        ois.close();
    }
//序列化流
    private static void write(ArrayList<Hero> heroes) throws IOException {
        ObjectOutputStream oos=new ObjectOutputStream//注意，不能开启追加续写!!!
                (new FileOutputStream("week8//src//main//java//com//xin//g_SerializationStream//hero.txt"));
        //这种方法在不确定对象数量无法使用,因此可以考虑直接序列化一个集合，于是反序列化一个集合就可以取出所有对象
        /*
            for (Hero h:heroes) {
                oos.writeObject(h);
            }
        */
        oos.writeObject(heroes);//直接序列化一个集合，于是反序列化一个集合就可以取出所有对象
        oos.close();
    }
}
