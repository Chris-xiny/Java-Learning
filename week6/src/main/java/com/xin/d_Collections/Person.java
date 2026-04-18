package com.xin.d_Collections;

public class Person implements Comparable<Person> {//方法二重写Comparable接口实现compareTo方法
    private String name;
    private Integer age;

    public Person(){

    }
    public Person(String name,Integer age){
        this.name=name;
        this.age=age;
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
    public String toString(){
        return "Person{"+name+age+'}';
    }
    @Override
    public int compareTo(Person p){
        return this.getAge()-p.getAge();
    }
}
