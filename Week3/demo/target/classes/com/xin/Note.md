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

Note 3:   BigInteger类：数字形式的字符串
        
Note 4:   BigDecimal类
    作用:解决float或double直接做运算出现的精度损失问题
    构造方法: BigDecimal(String val)  //不推荐直接传double,而是数字格式的String值
    方法:
        BigDecimal add(BigDecimal val) this+val
        BigDecimal subtract(BigDecimal val) 返回this-val
        BigDecimal multiply(BigDecimal val) 返回this*val
        BigDecimal divide(BigDecimal val) 返回this/val   //如果除不尽会报错
        BigDecimal divide(BigDecimal division,int scale,int roundingMode) 返回this/division,其中scale是精确到小数点几位，roundingMode是取舍方法
        double doubleValue() 返回值为this的double类对象

Note 5:   Date日期类
    构造方法:
        Date()
        Date(long time)传入毫秒，从时间原点1970年1月1日0时0分0秒开始算起,但北京时区差8小时，因此从8时0分0秒算起，1000ms=1s
    方法:
        void setTime(long time):与有参构造类似
        long getTime():获取时间，返回毫秒值

Note 6:   Calendar日历类
    概述:抽象类
    获取:静态方法 static Calendar getInstance();//注意，国外数月份从0开始，即0-11月，并且一周里周日为1
    方法:
        int get(int field):返回给定日历字段的值,如传入的field为Calendar.YEAR,则返回年
        void set(int field,int value):将给定日历字段设置为指定值
        void set(int year,int month,int date):设置年月日
        void add(int field,int amout):根据日历规则,为给定的日历字段添加或减去指定的时间量
        Date getTime():转为Date对象

Daily:
    day1:String的其他方法
    day2:StringBuilder类与Math类
    day4:Date类