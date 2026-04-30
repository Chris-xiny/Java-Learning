                二十一章IO流:File流、字节流、字符流
===============================================================================================================================
分隔符:
    a.路径名称分隔符
        Windows:\          注:Java中一个'\'代表转义字符,因此写路径时应该是"\\",前一个'\'将后一个'\'转译成普通'\'，就是正确的路径了
        Linux:/
    b.路径分隔符  ;

-------------第一章:File流-------------
Note 1:File流
    1.概述:文件和目录(文件夹)路径名的抽象表示
    2.简单理解:创建File对象时,需要传递一个路径,该路径定位到哪个文件或文件夹,该File对象就代表哪个
    3.File的静态成员
        static String pathSeparator:与系统有关的路径分隔符,为了方便,他被表示为一个字符串    ;
        static String separator:与系统有关的默认名称分隔符,为了方便,他被表示为一个字符串    \ /

        在往后Java开发中路径可能会这样写: String path="E:\\Code\\Java\\Intern\\week8\\Note.md";
        但有个问题,这样写只在Windows生效如果Linux呢?我们可以这样:
            String path="E:"+File.separator+"Code"+File.separator+"Java"......+File.separator+"Note.md";
    4.File的构造方法:    
        File(String parent,String child)    根据所填写的路径创建File对象
            parent:父路径           child:子路径
        File(File parent,String child)      根据所填写的路径创建File对象
            parent:父路径,是一个File对象           child:子路径
        File(String pathname)               根据所填写的路径创建File对象
            pathname:直接指定路径
    5.File的常用方法:
        a.获取方法:
            String getAbsolutePath()    :获取File的绝对路径(带盘符的路径)  //如果没有盘符,他会在前面自动补充当前项目的路径
            String getPath()            :获取的是封装路径(new对象写的啥路径就是什么路径)
            String getName()            :获取的是文件或文件夹的名称
            long length()               :获取的是文件的长度(文件的字节数)
        b.创建方法:
            boolean createNewFile()     :创建文件
                如果要创建的文件之前有,创建失败,返回false
                如果要创建的文件之前没有,创建成功,返回true
            boolean mkdirs()             :创建文件夹(目录)既可以创建多级文件夹,还可以创建单级文件夹
                如果要创建的文件夹之前有,创建失败,返回false
                如果要创建的文件夹之前没有,创建成功,返回true
    6.File的删除方法:
        boolean delete()                :删除文件或文件夹
            慎用：a.删除了文件或文件夹不会进回收站  b.文件夹只能是空文件夹才能删除
    7.File的判断方法:
        boolean isDirectory()           :判断是否为文件夹
        boolean isFile()                :判断是否为文件
        boolean exists()                :判断文件或文件夹是否存在 
    8.File的遍历方法:
        String[] list()                 :遍历指定文件夹,返回的是String数组
        File[] listFiles()              :遍历指定文件夹,返回的是File数组(这个推荐使用)
            细节:listFiles方法底层还是用list方法,先调用list方法得到一个String数组，遍历数组将内容一个一个封装到
            File对象中,再将所有File对象放入File数组并返回.
    9.Practice：遍历指定文件夹下所有.jpg文件
        a.创建File对象,指定要遍历的文件夹
        b.调用listFiles(),遍历文件夹,返回File数组
        c.遍历File数组,在遍历过程中判断,如果是文件,获取文件名,判断是否以.jpg结尾的,如果是则输出
        d.否则是文件夹,递归重复2 3 4步骤.
    10.相对路径与绝对路径
        1.绝对路径:从盘符开始写的路径
            E:\\idea\\io\\1.txt
            如:我要写信给美国的朋友,地址要写清楚美国(盘符)哪个州哪个区
        2.相对路径:不从盘符开始写的路径
            如:我要写信给国内的朋友写信,地址就不用写中国(盘符)了，直接写哪个省哪个区
        3.针对idea中写相对路径:
            口诀:哪个路径是参照路径,哪个路径就可以省略不写,剩下的就是在idea中的相对路径写法
                idea中的参照路径：当前projrct的绝对路径

-------------第二章:字节流-------------*****************
Note 2:IO流介绍以及输入输出以及流向的介绍
    1.单词:
        Output:输出
        Input:输入

        write:写数据
        read:读数据
    2.IO流:
        将一个设备的数据传输到另外一个设备上的技术
    3.作用:
        a.之前学的集合与数组存储的数据是临时数据(保存在内存当中,代码运行完就消失),而IO流可以将数据存储到硬盘中
        b.将来传输数据,也必然用到输入与输出
    


-------------第三章:字符流-------------*****************