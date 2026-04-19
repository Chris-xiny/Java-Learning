package com.xin.e_genericity;

public class Demo01Genericity {
    //定义一个含有泛型的方法addAll()
    public static <E> void addAll(MyArrayList<E> list,E...e){//可变参数e是个数组，需要遍历
        for (E element : e) {
            list.add(element);
        }
    }
    public static void main(String[] args) {
        //含有泛型的类
        MyArrayList<String> mylist=new MyArrayList<>();
        mylist.add("张三");
        mylist.add("李四");
        System.out.println(mylist.get(1));
        System.out.println(mylist);

        //含有泛型的方法
        System.out.println("====================================");
        Demo01Genericity.addAll(mylist, "王五","赵六");
        System.out.println(mylist);

        //含有泛型的接口
        System.out.println("====================================");
        boolean flag=mylist.remove("赵六");
        System.out.println(flag);
        System.out.println(mylist);

        //泛型通配符,加入用一个静态方法method能够遍历不同类型的MyArrayList,条件:method不定义为泛型方法
        System.out.println("====================================");
        MyArrayList<Integer> mylist1=new MyArrayList<>();
        mylist1.add(1);
        mylist1.add(2);
        method(mylist);//遍历String类型
        method(mylist1);//遍历Integer类型
    }
    public static void method(MyArrayList<?> list){//用泛型通配符定义method方法
        for (int i = 0; i < list.size; i++) {
            System.out.println(list.get(i));
        }
    }
}
