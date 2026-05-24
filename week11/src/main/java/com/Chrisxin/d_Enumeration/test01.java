package com.Chrisxin.d_Enumeration;

public class test01 {
    public static void main(String[] args) {
        State unshipped=State.UNSHIPPED;
        System.out.println(unshipped.getName());

        State paid=State.PAID;
        System.out.println(paid.getName());

        System.out.println("==============");
        //枚举的方法
        System.out.println("UNPAID.toString..."+State.UNPAID.toString());

        State[] values = State.values();
        for (State value : values) {
            System.out.println(value);
        }

        State shipped = State.valueOf("SHIPPED");
        System.out.println("shipped..."+shipped);

    }
}
