package com.xin.d_Poker;

import java.util.ArrayList;
import java.util.Collections;
//用ArrayList集合与Collections的方法模拟斗地主洗牌发牌
public class Poker{
    public static void main(String[] args) {
        //存花色，用String的静态方法split将该字符串按照传入的字符串切开成多个元素，返回数组
        String[] color="黑桃-红心-梅花-方块".split("-");
        //存基本牌
        String[] number="2-3-4-5-6-7-8-9-10-J-Q-K-A".split("-");
        //存花色和基本牌的组合牌
        ArrayList<String> poker=new ArrayList<>();
        for (int i = 0; i < number.length; i++) {
            for (int j = 0; j < color.length; j++) {
                poker.add(color[j]+number[i]);
            }
        }
        poker.add("大王");
        poker.add("小王");
        //System.out.println(poker);
        //洗牌
        Collections.shuffle(poker);
        //创建三个玩家和地主牌
        ArrayList<String> p1=new ArrayList<>();
        ArrayList<String> p2=new ArrayList<>();
        ArrayList<String> p3=new ArrayList<>();
        ArrayList<String> dizhuP=new ArrayList<>();
        for (int i = 0; i < poker.size(); i++) {
            if(i>=51){
                dizhuP.add(poker.get(i));
            }else if(i%3==0){
                p1.add(poker.get(i));
            }else if(i%3==1){
                p2.add(poker.get(i));
            }else if(i%3==2){
                p3.add(poker.get(i));
            }
        }
        System.out.println("p1:");
        System.out.println(p1);
        System.out.println("=======================================");
        System.out.println("p2:");
        System.out.println(p2);
        System.out.println("=======================================");
        System.out.println("p3:");
        System.out.println(p3);
        System.out.println("=======================================");
        System.out.println("地主牌:");
        System.out.println(dizhuP);
    }
}