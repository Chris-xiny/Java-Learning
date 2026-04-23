package com.xin.c_Map;

public class Person {//没有重写hashCode与equals方法,无法去重

    private String name;
    private Integer age;
    public Person() {
    }
    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }
    
}
