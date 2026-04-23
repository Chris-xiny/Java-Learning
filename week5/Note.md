
-------------第三章:线程安全-------------
Note 1:   线程安全问题_同步代码块
    原因:CPU在多个线程做高速切换
    解决方法1:使用同步代码块
        1.格式：
            synchronized(任意对象){
                线程可能出现不安全的代码
            }
        2.任意对象:锁对象(eg:两个人抢的一个厕所)
        3.执行:
            一个线程拿到锁后会进入同步代码块中执行，在此期间其他线程拿不到锁进不去同步代码块，
            只能等待有锁的线程执行完后释放锁才能抢锁
    解决方法2:使用同步方法  
        a.普通同步方法(非静态): 修饰符 synchronized(关键字) 返回值类型 方法名 (){
            方法体
            return 结果
        }
        默认锁:this
        b.静态同步方法: 修饰符 static synchronized 返回值类型 方法名 (){
            方法体
            return 结果
        }
        默认锁:class对象


-------------第四章:死锁-------------
Note 2:   死锁(有可能出现在锁嵌套时)
    介绍两个或两个以上线程竞争同步锁而阻塞的现象，如果没有外力，他们会一直阻塞下去。

Note 3:   线程的状态
   ![alt text](image-1.png)
   ![alt text](image.png)
   注意:基本数据类型不能作为锁对象(引用数据类型)，因为他们没有继承Object类，而锁需要支持wait()与notify()等方法，它们定义在Object类中


                            十七章.多线程:等待唤醒_Lock锁_Callable接口_线程池_定时器Timer
====================================================================================================
-------------第一章:多线程等待唤醒-------------
Note 4: 多线程等待唤醒
    1.等待唤醒机制
        方法:
            void wait()
            void notify()
            void notifyAll()
        案例:一个人包包子，一个人吃包子，但是不能连续包和吃包子。(包一个吃一个)
        问题1:怎么表示包包子和吃包子?   
            a.包包子:count++   b.吃包子:输出count.
        问题2:怎么证明有没有包子?    
            flag=true 表示有包子，false为没有包子.
        问题3:如何防止生产到一半，CPU切换到吃包子的线程?
            加锁.
        问题4:如何解决即使加锁也不能保证包一个吃一个?
            使用wait()与notify()方法.


-------------第二章:Lock锁-------------
Note 5: Lock锁
    1.Lock是一个接口
    2.实现类:ReentrantLock
    3.方法:
        lock():获得锁
        unlock():释放锁
    与synchronized的区别:
        synchronized:不管是同步代码块还是同步方法,都需要在结束一对{}后才释放锁
        Lock:通过两个方法控制需要被同步的方法，更灵活


-------------第三章:Callable接口-------------
Note 6: Callable接口_实现多线程的方法三
    1.Callable是一个接口，类似于Runnable
    2.方法:
        V call():设置线程任务，类似于run()
    3.call()与run()的区别:
        a.相同点:都是设置线程任务
        b.不同点:
            call()方法有返回值,并且有异常可以throws
            run()方法没有返回值，而且有异常不能throws
    4.<V>
        a.<V>叫做泛型
        b.泛型:用于指定我们操作什么类型的数据,<>中只能写引用数据类型，如果泛型不写，默认Object类型
        c.实现Callable接口时,指定泛型是什么类型,重写的call方法返回值就是什么类型的
    5.获取call方法返回值:FutureTask<V>
        a.FutureTask<V>实现了一个接口:Future<V>
        b.FutureTask<V>中有一个方法:
            V get():获取call()中的返回值


-------------第四章:线程池-------------
Note 7: 线程池_实现多线程方式四
    1.问题:之前完成一个线程任务就需要创建一个线程，用完就销毁，如此往复频繁创建销毁，能不能循环利用线程?
    2.创建线程池对象?  
        用工具类Executors中的静态方法:
            static ExecutorService newFixedThreadPool(int nThreads)
            a.参数:指定线程池中最多能创建的线程数
            b.返回值ExecutorService 是线程池，用来管理线程对象
    3.怎么执行线程任务?
        用ExecutorService中的
            Future<?> submit(Runnable task)  提交一个Runable的任务执行
            Future<T> submit(Callable<T> task) 提交一个Callable的任务执行
    4.方法的返回值为Future接口
        用于接收run或call方法的返回值的，但是run没有返回值可以不用接收，而call方法需要Future接收
        Future中的V get()  用于获取call的返回值
    5.ExecutorServce中的
        void shutdown()  启动有序关闭，其中先提交的任务将被执行，但不会接受任何新任务


-------------第五章:定时器Timer-------------
Note 8: 定时器_Timer
    1.构造:Timer()
    2.执行:
        void schedule(TimerTask task,Date firstTime,long period)
        a.task:抽象类,是一个实现了Runnable的类
        b.firstTime:从什么时间开始执行
        c.period:每隔多久执行一次,设置的是毫秒值ms
    3.使用见h_Timer包

