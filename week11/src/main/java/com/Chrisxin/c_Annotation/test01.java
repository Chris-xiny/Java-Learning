package com.Chrisxin.c_Annotation;

import java.util.Arrays;

public class test01 {
    public static void main(String[] args) {
        Class<BookShelf> bookShelf = BookShelf.class;
        boolean flag = bookShelf.isAnnotationPresent(Book.class);
        if (flag) {
            Book book = bookShelf.getAnnotation(Book.class);
            System.out.println(book.bookName());
            System.out.println(Arrays.toString(book.author()));
            System.out.println(book.price());
            System.out.println(book.count());
        }
    }
}
