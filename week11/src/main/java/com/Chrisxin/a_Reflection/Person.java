package com.Chrisxin.a_Reflection;

public class Person {
    private String name;
    private Integer i;

    private Person(String name, Integer i) {
        this.name = name;
        this.i = i;
    }

    public Person() {
    }

    public Integer getI() {
        return i;
    }

    public void setI(Integer i) {
        this.i = i;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", i=" + i +
                '}';
    }
}
