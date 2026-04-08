package com.xin;

import java.math.BigDecimal;

public class DemoBigDecimal {

    public static void main(String[] args) {
        BigDecimal bd = new BigDecimal("1.26");
        System.out.println(bd.multiply(new BigDecimal("1.3")).toString());
        // System.out.println(bd.divide(new BigDecimal("1.3"), 2,
        // BigDecimal.ROUND_DOWN).toString());//过期的方法
    }

}
