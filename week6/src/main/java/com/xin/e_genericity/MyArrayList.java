package com.xin.e_genericity;

import java.util.Arrays;

public class MyArrayList <E> implements MyInterface<E>{//定义泛型,变量名随便取;实现定义泛型的接口
    private Object[] obj=new Object[10];//充当ArrayList的底层数组
    int size=0;//元素数量
    public void add(E e){
        obj[size]=e;
        size++;
    }
    public E get(int index){//返回值为e
        return (E) obj[index];//要强转
    }
    @Override
    public String toString(){
        return Arrays.toString(obj);
    }
    public boolean remove(E e){
        {
            int i=-1;
            for (Object element:obj) {
                i++;
                if(e.equals(element)){
                    obj[i]=null;
                    size--;
                    return true;
                }
            }
            return false;
        }
    }
}