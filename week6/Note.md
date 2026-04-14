Note 1: 集合
    1.集合的特点:
        a.只能储存引用数据类型
        b.长度可变
        c.集合中有大量的方法可以使用
    2.集合的分类:
        a.单列集合:一个元素就一个组成部分
            eg: list.add("你好")
        b.双列集合:一个元素由两部分组成:key和value(叫做键值对)
            eg: map.put("张三","你好")

Note 2: 单列集合
![alt text](note2.png)
tips!!!: LinkedList其实本质无索引，只是提供了根据索引进行的方法!

Note 3: Collection接口
    1.概述：单列集合的顶级接口
    2.使用:
        a.创建: Collection<E> 变量名=new 实现类<E>();
        b.<E>:泛型，决定了该集合能储存什么数据类型，只能写引用数据类型，不写默认Object类型，可以储存任意类型
    3.常用方法:
        ![alt text](note3.png)

Note: 迭代器
    1.Iterator接口
    2.主要作用:遍历集合
    3.获取:Collection中的方法:
        Iterator<E> iterator();
    4.方法:
        boolean hasNext():判断集合中有没有下一个元素
        E next():获取下一个元素    小细节:最好不要同时next多个元素，除非保证每个next都有检查过hasNext,
                                  不然可能超出集合范围,触发NoSuchElementsException异常

