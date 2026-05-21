package com.Chrisxin.d_design.Singleton;

public class Test01 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Starving_Man_Style.getInstance());
                    System.out.println(Lazyman_Style.getInstance());
                }
            }).start();
        }
    }
}
