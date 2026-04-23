Note 1:
    静态代码块只在第一次创建类对象时调用,很适合JDBC初始化连接时使用
        使用方法:类定义中:static{ 代码 } 即可

                                    十三章.异常_comparable接口与comparator接口_Object类
================================================================================
-------------第一章:异常-------------
Note 2:
    异常:
        Throwable类包括Errow类(错误类，代码语法错误需大改动)与Exception类(异常类，小错误),
        Exception异常包括编译时期异常(Exception类以及子类,除了RuntimeExceptuon类)与运行时期异常(RuntimeException类及其子类)
    异常处理:(见demo_01)
        出现异常若无法处理虚拟机会将异常往上抛,即谁带调用出来的异常就抛给谁解决,
        若都无法解决直到main方法又抛回给jvm,jvm就会打印异常信息并退出程序,由此有两种解决方式:
                a.throws:在方法参数与方法体之间加上throws 异常(可多个,若多个异常有共同父类可直接throws 父异常),将异常往上抛让上面的去解决
                b.try{}catch{}:添加异常处理,可有多个catch捕获多个异常
    finally:
        放在try_catch后,finally{代码},finally里的代码最终都会执行,除了System.exit(0)


-------------第二章:comparable接口与comparator接口-------------
Note 3:
    comparable:作用相当于cpp的重写比较运算符,适用于可以修改的待比较类，该类直接继承接口并重写
        使用方法:要比较的类重写接口的方法后，直接a.compareTo(b);
    comparator:与前者相反，当要比较的类我们不好修改源码时，创建一个新的比较类来继承接口并重写
        使用方法:创建新的类重写接口的方法后，直接new一个新类对象.compare(a,b);
    both:大于返回正整数，等于返回0，小于返回负整数


-------------第三章:Object类-------------
Note 4:
    Object类:是所有类的根类
    方法：
        toString();//返回该对象的字符串表示(eg:Person类的name与age描述该对象)
        equals();//比较两个对象的地址值是否相等，一般没啥用所以会重写用于比较该类的内容是否相等
        clone();//需要类实现Cloneable接口去重写clone方法，用于克隆一个内容相同的新对象

                                    十四章.API：String类基础知识与StringBuilder类
================================================================================
-------------第一章:String类基础知识-------------
Note 5:
    String:字符串类型，本质是一个被final修饰的byte数组s
    创建:
        1.String无参构造
        String();
        2.根据字符串创建新的字符串
        String(String original);
        3.根据char数组创建新的字符串
        String(char[] value);
        4.通过使用平台的默认字符集解码指定的byte数组，构造一个新的String
        String(byte[] bytes);
            tips:GDK字符集中文占两字节。UTF-8占三字节，而且中文对应的字节一般都是负数
        5.简化型
        String s="abc";
    方法：
    boolean equals(String ):比较两个字符串是否相等
    boolean equalsIgnoreCase(String):比较时无视大小写
    boolean contains(String ):传入的串是否包含在本串中
    boolean endsWith(String):是否以参数结尾
    boolean startsWith(String):是否以参数开头
    String toLowerCase():将字母转为小写
    String toUpperCase():将字母转为大写
    String trim():去掉字符串两端空格



-------------------------------------------------
Daily:
    day1:多态
    day2:权限修饰符,代码块
    day3:异常处理,finally的使用
    day5:自定义异常
    day6:Object类,comparable接口与comparator接口
    day7:常用API:String