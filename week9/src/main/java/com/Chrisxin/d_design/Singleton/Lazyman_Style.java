package com.Chrisxin.d_design.Singleton;

public class Lazyman_Style {
    /*
        为了防止外界随意用构造方法new对象，我们将其私有化
    */
    private Lazyman_Style() {

    }

    /*懒汉式，不急着得到对象
     * 为了不让外界随意使用对象，将其私有化*/
    private static Lazyman_Style instance = null;

    /*提供一个方式供外界获取对象
     * 注意同步问题可能导致new多次*/
    public static Lazyman_Style getInstance() {
        //但是如果instance!=null,那就不需要抢锁判断了
        if (instance == null) {
            synchronized (Lazyman_Style.class) {
                if (instance == null) {
                    instance = new Lazyman_Style();
                }
            }
        }
        return instance;
    }
}
