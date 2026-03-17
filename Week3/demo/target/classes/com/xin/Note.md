Note 1:   StringBuilder类
    StringBuilder类:可变的字符序列，此类提供了与StringBuffer兼容的一套API，但是不保证同步(线程不安全但效率高)
    作用:主要是字符串拼接
    使用原因:String每拼接一次会产生新字符串对象，在堆内存中开辟新的空间，占用内存;
            而StringBuilder底层自带一个缓冲区(没有被final修饰的byte数组)拼接字符串后都会在此缓冲区保存，在拼接时不会随意产生新对象，节省内存。
    特点:
        1.底层自带一个缓冲区,一个没有被final修饰的byte数组，默认长度16
        2.如果超过数组长度，会自动扩容，默认扩容原数组的length*2+2,若还不够则以实际长度为准
    方法:
        1.StringBuilder append(任意类型数据):字符串拼接
        2.StringBuilder reverse():字符串反转
        3.String toString():转为String类型

Note 2:   Math类    
    Math类:数学工具类，主要用于数学运算
    特点:   (工具类一般都有这几个特点，方便使用)
        1.构造方法私有
        2.方法都是静态
    使用：类名直接调用
    方法:
        1.static int abs(int):求绝对值
        2.static double ceil(double):向上取整
        3.static double floor(double):向下取整
        4.static long round(double):四舍五入
        5.static int max(int,int):求最大值
        5.static int min(int,int):求最小值


Daily:
    day1:String的其他方法
    day2:StringBuilder类与Math类