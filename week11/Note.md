    二十五章反射_注解:类的加载实际_反射_注解_元注解_枚举
**本章重点掌握:Junit(在Javaweb中学习)、反射与注解**
# 第二章. 类的加载时机

以下是Java中触发类加载的常见场景：

1. `new`对象（创建类的实例）
2. `new`子类对象（创建子类实例时，会先初始化父类）
3. 执行类的`main`方法
4. 调用类的静态成员（静态变量或静态方法）
5. 通过反射创建`Class`对象
   ![img_1.png](img_1.png)

## 1. 类加载器（基于 JDK 8）_ClassLoader

### 1. 概述

在 JVM 中，负责将本地的 `.class` 文件加载到内存的对象，就是 `ClassLoader`（类加载器）。

### 2. 分类

- **`BootstrapClassLoader`（根类加载器）**
    - 由 C 语言编写，Java 代码中无法直接获取。
    - 也叫引导类加载器，负责加载 Java 核心类（如 `System`、`String` 等，位于 `jre/lib/rt.jar` 下）。

- **`ExtClassLoader`（扩展类加载器）**
    - 负责加载 JRE 扩展目录（`jre/lib/ext`）中的 jar 包。

- **`AppClassLoader`（系统类加载器）**
    - 负责加载自定义类（通过 `java` 命令运行的类），以及 `classpath` 环境变量指定的第三方 jar 包。

### 3. 三者的关系

- **从类加载机制层面（双亲委派模型）**：
    - `AppClassLoader` 的父加载器是 `ExtClassLoader`
    - `ExtClassLoader` 的父加载器是 `BootstrapClassLoader`
- **从代码继承关系看**：它们之间没有父子继承关系，都继承自同一个父类 `ClassLoader`。

### 4. 获取类加载器对象

通过 `Class` 对象的 `getClassLoader()` 方法获取： 类名.class.getClassLoader();

### 5. 获取类加载器对象对应的父类加载器

通过 ClassLoader 类的 getParent() 方法获取（实际使用场景较少）。

### 6. 双亲委派机制（全盘负责委托机制）

1. **示例**：`Person` 类中有一个 `String` 成员
    - `Person` 类由 `AppClassLoader` 加载
    - `String` 类由 `BootstrapClassLoader` 加载

2. **加载流程**：
    - `AppClassLoader` 在加载 `String` 时，会先委托给父加载器 `ExtClassLoader`。
    - `ExtClassLoader` 无法加载核心类，继续委托给它的父加载器 `BootstrapClassLoader`。
    - `BootstrapClassLoader` 识别出 `String` 是核心类，由它完成加载。

---

### 7. 类加载器的缓存（Cache）机制

- 类被加载到内存后，会在缓存中保存一份。
- 后续使用该类时，会直接从缓存中获取，不会重新加载。
- 作用：**保证了类在内存中的唯一性**。

---

### 8. 总结

双亲委派机制与缓存机制共同作用，保证了类在内存中的唯一性。
![img_2.png](img_2.png)
---

# 第三章. 反射

## 1. Class类与反射介绍

1. **反射概述**：一种“解剖`Class`对象”的技术。
2. **反射能解剖的内容**：
    - 成员变量：用于赋值
    - 成员方法：用于调用
    - 构造方法：用于创建对象
3. **反射的好处**：让代码更通用、更灵活。
4. **学习思路**：
    - 将反射看作一套API来学习
    - 通过案例体会反射的优势
5. **反射的第一步**：获取`Class`对象。
6. **概念区分**：
    - `Class`对象：`.class`文件在内存中对应的对象。
    - `Class`类：描述`Class`对象的类，即`java.lang.Class`。
      ![img.png](img.png)

## 2. 反射之获取Class对象

### 获取`Class`对象的三种方式

1. **方式1：调用`Object`类的`getClass()`方法**:
   Class<?> clazz = 对象.getClass();
2. **方式2：使用类的静态成员class
   基本类型和引用类型都支持，格式为**：Class<?> class = 类名.class;
3. **方式 3：调用Class类的静态方法forName()**:Class<?> clazz = Class.forName("类的全限定名");
   其中，参数是类的全限定名（即包名.类名）。

### 2.1 三种获取`Class`对象的方式中最`通用`的一种

1. **核心方式**：方式 3：调用Class类的静态方法forName()**:Class<?> clazz = Class.forName("类的全限定名");
   其中，参数是类的全限定名（即包名.类名）。
2. 原因:String为参数时,可以结合Properties文件使用

### 2.2 三种获取`Class`对象的方式中最`常用`的一种

直接类名.class

## 3. 获取Class对象中的构造方法

### 3.1 获取所有public的构造方法

1. Class类中的方法：
   ```
   Constructor<?>[] getConstructors()//获取类中所有public修饰的构造方法
   
   ```

### 3.2 获取空参构造（public）

1. **Class类方法：获取指定public构造方法**

```
    Constructor<T> getConstructor(Class<?>... parameterTypes);
```

- parameterTypes：可变参数，可传 0 个或多个
    - 获取空参构造：不写参数
    - 获取有参构造：传入参数类型的 Class 对象

2. **Constructor 类方法：创建对象**

```
    T newInstance(Object... initargs);
```

- initargs：构造方法的实参
    - 无参构造：不写参数
    - 有参构造：传入对应实参
- 示例

```
public class Demo04GetConstructor {
    public static void main(String[] args) throws Exception {
        // 1. 获取Class对象
        Class<Person> aClass = Person.class;

        // 2. 获取public空参构造方法
        Constructor<Person> constructor = aClass.getConstructor();
        System.out.println("constructor = " + constructor);

        // 3. 使用空参构造创建对象（等价于 new Person()）
        Person person = constructor.newInstance();

        // 4. 输出对象
        System.out.println(person);
    }
}   
```

### 3.3 获取私有构造(暴力反射)

1. **Class类方法：获取所有构造方法(包括私有)**

```
    Constructor<?>[] getDeclaredConstructors();//获取类中所有构造方法(包括私有)
    Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes);//获取类中指定构造方法(私有也可以指定)
```

- parameterTypes：可变参数，可传 0 个或多个
    - 获取空参构造：不写参数
    - 获取有参构造：传入参数类型的 Class 对象

2. **暴力反射**:Constructor有一个父类叫做AccessibleObject,里面有个方法

- void setAccessible(boolean flag)->修改访问权限(修改后才能使用该构造)
    - flag为true，解除私有权限

## 4. 反射方法

### 4.1 利用反射获取所有public成员方法

- `Class`类方法：
  ````
  Method[] getMethods();//作用：获取当前类及所有父类中所有public修饰的成员方法。
  //示例代码
  private static void method01() {
    Class<Person> aClass = Person.class;
    Method[] methods = aClass.getMethods();
    for (Method method : methods) {
        System.out.println(method);
    }
  } 
  ````

### 4.2 反射获取指定 public 成员方法（有参 / 无参）

- `Class`类方法：

 ````
    Method getMethod(String name, Class<?>... parameterTypes);
    //name：要获取的方法名
    //parameterTypes：方法参数类型的 Class 对象（无参方法可省略）

````

- **方法调用:** 成员方法对象.invoke(操作对象,方法参数),如果方法有返回值，则可以直接接收invoke的返回值,没有则null

### 4.3 反射之操作私有成员方法

1. **Class类方法：获取所有构造方法(包括私有)**

```
    Constructor<?>[] getDeclaredMethods();//获取类中所有成员方法(包括私有)
    Constructor<T> getDeclaredMethod(String name,Class<?>... parameterTypes);//获取类中指定成员方法(私有也可以指定)
```

- parameterTypes：可变参数，可传 0 个或多个
    - name：传递方法名
    - 获取有参方法：传入方法参数的 class 对象

2. **操作方法:** void setAccessible(boolean flag)->修改访问权限
    - flag为true，解除私有权限
3. **调用方法:**  invoke(类对象,方法参数);

## 5. 反射成员变量

### 5.1 获取所有属性（Java反射）

- **Class类方法：**
    1. `Field[] getFields()`：获取类中所有 `public` 修饰的属性（成员变量）。
    2. `Field[] getDeclaredFields()`：获取类中**所有**属性，包括 `private`、`protected`、默认访问权限的属性。

## 5.2 获取指定属性（Java反射）

### 1. `Class`类中的方法

1. `Field getField(String name)`
   作用：获取指定名称的`public`属性。
2. `Field getDeclaredField(String name)`
   作用：获取指定名称的属性，包括`private`修饰的属性。

### 2. `Field`类中的方法

1. `void set(Object obj, Object value)`
   作用：为属性赋值，相当于JavaBean中的`set`方法。
    - `obj`：要操作的对象
    - `value`：要赋予的新值
2. `Object get(Object obj)`
   作用：获取指定对象的属性值。
    - `obj`：要操作的对象

## 6. 反射练习（编写一个小框架）

### 1. 定义接口

```
public interface 接口名 {
    public Employee find();
}
```

````
<select id="find" resultType="Employee的全限定名">
    select 列名 from 表名 where 条件
</select>
根据接口的Class对象，创建一个实现类对象，然后通过配置文件中的方法名反射这个方法，使用invoke执行这个方法。
````

---

````
需求:在配置文件中配置类的全限定名和方法名，通过解析配置文件，让配置好的方法自动执行。

配置文件示例（config.properties）：
className=包名.Person
methodName=eat

实现步骤:

1. 创建配置文件
   配置文件建议放在resources资源目录下，确保编译后能被打包到out目录中。(Maven在target目录)

2. 读取并解析配置文件
   加载配置文件，读取className和methodName。
   a.如何读取配置文件?
        直接new FileInputStream("模块名\\resources\\properties文件名")->不行,因为out目录下没有resources->相当于写死了
   b.解决方法:用类加载器
        ClassLoader classLoader=当前类.class.getClassLoader();
        InputStream in=classLoader.getResourceAsStream("properties文件名");//自动扫描resources下的文件
        
   

3. 根据解析出来的className创建Class对象
   通过解析出的全限定类名，使用Class.forName(className)获取类的Class对象。

4. 根据解析出来的methodName获取目标方法
   通过解析出的方法名，使用getMethod(methodName)获取对应的Method对象。

5. 执行方法
   创建类的实例，并通过method.invoke()方法执行目标方法。
````

# 第四章.注解

## 1.注解的介绍

````
1.引用数据类型：
    类 数组 接口 枚举 注解

1.jdk1.5版本的新特性->一个引用数据类型
    和类，接口，枚举是同一个层次的
    引用数据类型:类 数组 接口 枚举 注解

2.作用：
    说明:对代码进行说明,生成doc文档(API文档)
    检查:检查代码是否符合条件 @Override(会用) @FunctionalInterface
    分析:对代码进行分析,起到了代替配置文件的作用(会用)

3.JDK中的注解：
    @Override -> 检测此方法是否为重写方法
    jdk1.5版本,支持父类的方法重写
    jdk1.6版本,支持接口的方法重写
    @Deprecated -> 方法已经过时,不推荐使用
    调用方法的时候,方法上会有横线,但是能用
    @SuppressWarnings->消除警告 @SuppressWarnings("all")
````

---

## 2.注解的定义以及属性的定义格式

````
大家需要知道的是,咱们这里说的注解属性,其本质上是抽象方法,但是我们按照属性来理解,好理解,因为到时候使用注解的时候,需要用=为其赋值

1. 定义：
public @interface 注解名{
}

2. 定义属性：增强注解的作用
数据类型 属性名() -> 此属性没有默认值，需要在使用注解的时候为其赋值
数据类型 属性名() default 值 -> 此属性有默认值，如果有需要，还可以二次赋值

3. 注解中能定义什么类型的属性呢？
a. 8种基本类型
b. String类型，class类型，枚举类型，注解类型
c. 以及以上类型的一维数组
````

---

## 3.注解的使用(重点)

````
1.注解的使用:
说白了就是为注解中的属性赋值

2.使用位置上:
在类上使用,方法上使用,成员变量上使用,局部变量上使用,参数位置使用等

3.使用格式:
a.@注解名(属性名 = 值,属性名 = 值...)
b.如果属性中有数组:
@注解名(属性名 = {元素1,元素2...})
````

````
注解注意事项：
1. 空注解可以直接使用 -> 空注解就是注解中没有任何的属性
2. 不同的位置可以使用一样的注解，但是同样的位置不能使用一样的注解
3. 使用注解时，如果此注解中有属性，注解中的属性一定要赋值，如果有多个属性，用,隔开
   如果注解中的属性有数组，使用{}
4. 如果注解中的属性值有默认值，那么我们不必要写，也不用重新赋值，反之必须写上
5. 如果注解中只有一个属性，并且属性名叫value，那么使用注解的时候，属性名不用写，直接写值（包括单个类型，还包括数组）
````

## 4.注解解析的方法->AnnotatedElement接口

````
注解的解析:说白了就是将注解中的属性值获取出来

1.注解解析涉及到的接口:AnnotatedElement接口
实现类: AccessibleObject, Class, Constructor, Executable, Field, Method, Package, Parameter

2.解析思路:先判断指定位置上有没有使用指定的注解,如果有,获取指定的注解,获取注解中的属性值
a.boolean isAnnotationPresent(Class<? extends Annotation> annotationClass)->判断指定位置上有没有指定的注解
比如:判断BookShelf上有没有Book注解
Class bookShelf = BookShelf.class
bookShelf.isAnnotationPresent(Book.class)

b.getAnnotation(Class<T> annotationClass) ->获取指定的注解,返回值类型为获取的注解类型
比如:获取BookShelf上的Book注解
Class bookShelf = BookShelf.class
boolean result = bookShelf.isAnnotationPresent(Book.class)
如果result为true,证明BookShelf上有Book注解,那就获取
Book book = bookShelf.getAnnotation(Book.class)
````

````java
public class test01 {
    public static void main(String[] args) {
        Class<BookShelf> bookShelf = BookShelf.class;
        boolean flag = bookShelf.isAnnotationPresent(Book.class);
        if (flag) {
            Book book = bookShelf.getAnnotation(Book.class);
            System.out.println(book.bookName());
            System.out.println(Arrays.toString(book.author()));
            System.out.println(book.price());
            System.out.println(book.count());
        }
    }
}
/*
以上代码没有解析出来:
涛哥猜想:如果Book注解被加载到内存了,那么我们一定能判断出来BookShelf上有没有Book注解;
但是现在没有判断出来,但是BookShelf上确实用了Book注解了,所以涛哥猜想,Book注解有可能就没有在内存中出现
*/
````

## 第五章.元注解

````
1.概述:元注解就是管理注解的注解

2.从哪些方面管理呢?
    a.控制注解的使用位置
        控制注解是否能在类上使用
        控制注解是否能在方法上使用
        控制注解是否能在构造上使用等

    b.控制注解的生命周期(加载位置)
        控制注解是否能在源码中出现
        控制注解是否能在class文件中出现
        控制注解是否能在内存中出现

3.怎么使用:
    a.@Target:控制注解的使用位置
        属性:ElementType[] value();
        ElementType是一个枚举,里面的成员可以类名直接调用
        ElementType中的成员:
            TYPE:控制注解能使用在类上
            FIELD:控制注解能使用在属性上
            METHOD:控制注解能使用在方法上
            PARAMETER:控制注解能使用在参数上
            CONSTRUCTOR:控制注解能使用在构造上
            LOCAL_VARIABLE:控制注解能使用在局部变量上
    b.@Retention:控制注解的生命周期(加载位置)
        属性:RetentionPolicy value();
        RetentionPolicy是一个枚举,里面的成员可以类名直接调用
        RetentionPolicy中的成员:
            SOURCE:控制注解能在源码中出现 -> 默认
            CLASS:控制注解能在class文件中出现
            RUNTIME:控制注解能在内存中出现

4.将Book注解添加一个Retention注解，参数为RetentionPolicy.RUNTIME,代码成功解析了
````

---
# 枚举

## 1.枚举介绍
````
1.概述:五大引用数据类型:
    类 数组 接口 注解 枚举

2.定义:
    public enum 枚举类名{
    }
    所有的枚举类父类都是Enum

3.定义枚举值:
    a.枚举值特点:都是static final,但是定义的时候不要写出来,写出来报错
        写完所有的枚举值之后,最后加个;
        枚举值名字要大写 -> 开发习惯
    b.使用:类名直接调用
    c.注意:每一个枚举值都是当前枚举类的对象

4.问题:枚举类中的枚举值都是什么类型的?
    本类类型

5.枚举类中其他成员:构造
    在枚举类中定义的构造,默认都是private的

6.枚举类的使用场景:
    表示对象的状态
````

## 2.枚举的方法_Enum

| 方法名                | 说明                         |
|-----------------------|------------------------------|
| String toString()     | 返回枚举值的名字             |
| values()              | 返回所有的枚举值             |
| valueOf(String str)   | 将一个字符串转成枚举类型     |
