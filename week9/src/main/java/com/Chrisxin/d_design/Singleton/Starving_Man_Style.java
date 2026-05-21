package com.Chrisxin.d_design.Singleton;

public class Starving_Man_Style {
    /*
        为了防止外界随意用构造方法new对象，我们将其私有化
    */
    private Starving_Man_Style(){

    }
    /*饿汉式，为了更快的能够得到对象，我们将对象静态化，让其在加载类的时候就new出来
    * 为了不让外界随意使用对象，将其私有化*/
    private static Starving_Man_Style instance=new Starving_Man_Style();
    /*提供一个方式供外界获取对象*/
    public static Starving_Man_Style getInstance(){
        return instance;
    }
}
