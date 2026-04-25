package com.xin.c_Map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
//用ArrayList集合与Collections的方法模拟斗地主洗牌发牌
public class Poker{
    public static void main(String[] args) {
        //存花色，用String的静态方法split将该字符串按照传入的字符串切开成多个元素，返回数组
        String[] color="黑桃-红心-梅花-方块".split("-");
        //存基本牌
        String[] number="2-3-4-5-6-7-8-9-10-J-Q-K-A".split("-");
        //key存储序号,value存储组合好的牌
        HashMap<Integer,String> poker=new HashMap<>();
        //list存储key
        ArrayList<Integer> list=new ArrayList<>();
        list.add(0);
        list.add(1);
        int key=2;
        //将组合好的牌面与序号放入map里，序号还得放入list
        for (String num:number) {
            for (String col:color) {
                String p=col+num+" ";
                poker.put(key,p);
                list.add(key);
                key++;
            }
        }
        poker.put(0,"大王 ");
        poker.put(1,"小王 ");
        //洗牌,打乱list序号
        Collections.shuffle(list);
        //创建三个玩家和地主牌
        ArrayList<Integer> p1=new ArrayList<>();
        ArrayList<Integer> p2=new ArrayList<>();
        ArrayList<Integer> p3=new ArrayList<>();
        ArrayList<Integer> dizhuP=new ArrayList<>();
        //发牌
        for (int i = 0; i < list.size(); i++) {
            if(i>=51){
                dizhuP.add(list.get(i));
            }else if(i%3==0){
                p1.add(list.get(i));
            }else if(i%3==1){
                p2.add(list.get(i));
            }else if(i%3==2){
                p3.add(list.get(i));
            }
        }
        //整理牌
        Collections.sort(p1);
        Collections.sort(p2);
        Collections.sort(p3);
        Collections.sort(dizhuP);
        //明牌
        checkPoker("张三",p1,poker);
        checkPoker("李四",p2,poker);
        checkPoker("王五",p3,poker);
        checkPoker("地主牌",dizhuP,poker);
    }
        
    private static void checkPoker(String name, ArrayList<Integer> list, HashMap<Integer,String> map) {
        System.out.print(name+':');
        for (Integer index : list) {
            System.out.print(map.get(index));
        }
        System.out.println();
    }
}