package com.Chrisxin.d_MethodReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private String name;
    private Integer age;
    public Person(String name){
        this.name=name;
        this.age=10;
    }
}
