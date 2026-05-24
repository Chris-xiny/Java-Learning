package com.Chrisxin.c_Annotation;

public @interface Book {
    //书名
    String bookName();
    //作者
    String[] author();
    //价格
    int price();
    //数量
    int count() default 10;
}
