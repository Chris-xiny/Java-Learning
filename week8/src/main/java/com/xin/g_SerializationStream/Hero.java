package com.xin.g_SerializationStream;

import java.io.Serializable;

public class Hero implements Serializable {//实现序列化接口
    private static final long serialVersionUID =123456L;//固定序列号，只要这个值不变，JAVA就会认为类的版本一致
    private String name;
    private Integer level;
    private String sex;//transient修饰的对象不被序列化

    public Hero() {
    }

    public Hero(Integer level, String name, String sex) {
        this.level = level;
        this.name = name;
        this.sex = sex;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", sex='" + sex + '\'' +
                '}';
    }
}
