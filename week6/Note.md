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

Note 4: 迭代器
    1.Iterator接口
    2.主要作用:遍历集合
    3.获取:Collection中的方法:
        Iterator<E> iterator();
    4.方法:
        boolean hasNext():判断集合中有没有下一个元素
        E next():获取下一个元素    小细节:最好不要同时next多个元素，除非保证每个next都有检查过hasNext,
                                  不然可能超出集合范围,触发NoSuchElementsException异常
    5.迭代过程:
        int cursor;  //下一个元素索引位置
        int lastRet=-1;  //上一个元素索引位置
    6.并发修改异常
    非线程安全集合不能随意在iterator遍历集合时修改集合长度，会抛出ConcurrentModificationException异常
    原因是他们内部维护了modCount变量(结构的操作次数，如添加删除清空)，而迭代器初始化时会将modCount赋值给expectedModCount(预期操作次数),
    每次迭代器调用next()或remove()时会调用CheckForComodification()检查modCount==expectedModCount,不等就抛出ConcurrentModificationException异常,而任何直接调用集合的 add()、remove()、clear() 等方法，都会使 modCount++,但迭代器中的expectedModCount却不变。
    不过迭代器自己的 remove() 方法会在删除后同步更新 expectedModCount，所以不会抛异常。
    ![alt text](note4.png)

Note 5: 数据结构
    1.栈:先进后出
    2.队列:先进先出
    3.数组:有索引所以查询快；数组定长所以增删慢
    4.链表:  查询慢，增删快
        a.单向链表
            1.一个节点分为两个部分:数据域(存数据)和指针域(保存下一个节点地址)
            2.特点:前节点保存后一个节点地址，但后一个不保存前面的地址，因此为单向

        b.双向链表
            1.一个节点分为三个部分:指针域(上一个节点地址)、数据域(存数据)、指针域(下一个节点地址)
            2.特点:前后节点地址都保存

Note 6: List接口
    1.是单列集合顶级接口Collection接口的子接口
    2.常见的实现类: ArrayList LinkedList Vector
    一、ArrayList类
        1.概述:是List接口的实现类
        2.特点:
            a.元素有序:什么顺序存，就什么顺序取
            b.元素可重复
            c.有索引:可根据索引查找
            d.线程不安全
        3.数据结构:数组
        4.常用方法:
            boolean add(E e)                    将元素添加到集合的尾部(add方法一定能添加成功的，所以我们不用boo1ean接收返回值)
            void add(int index，E element)      在指定索引位置上添加元素
            boolean remove(object o)            删除指定的元素，删除成功为true，失败为false
            E remove(intindex)                  删除指定索引位置上的元素，返回的是被删除的那个元素
            E set(int index，Eelement)          将指定索引位置上的元素，修改成后面的element元素
            E get(int index)                    根据索引获取元素
            int size()                          获取集合元素个数
        5.底层源码分析:
        ![alt text](note6_0.png)
        以后开发中注意:
        ![alt text](note6_1.png)
    二、LinkedList类
    三、Vector类




