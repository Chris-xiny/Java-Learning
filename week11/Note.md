    二十五章反射_注解:类的加载实际_反射_注解_元注解_枚举
# 第二章. 类的加载时机

以下是Java中触发类加载的常见场景：

1.  `new`对象（创建类的实例）
2.  `new`子类对象（创建子类实例时，会先初始化父类）
3.  执行类的`main`方法
4.  调用类的静态成员（静态变量或静态方法）
5.  通过反射创建`Class`对象
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
1.  **示例**：`Person` 类中有一个 `String` 成员
    - `Person` 类由 `AppClassLoader` 加载
    - `String` 类由 `BootstrapClassLoader` 加载

2.  **加载流程**：
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
1.  **反射概述**：一种“解剖`Class`对象”的技术。
2.  **反射能解剖的内容**：
    - 成员变量：用于赋值
    - 成员方法：用于调用
    - 构造方法：用于创建对象
3.  **反射的好处**：让代码更通用、更灵活。
4.  **学习思路**：
    - 将反射看作一套API来学习
    - 通过案例体会反射的优势
5.  **反射的第一步**：获取`Class`对象。
6.  **概念区分**：
    - `Class`对象：`.class`文件在内存中对应的对象。
    - `Class`类：描述`Class`对象的类，即`java.lang.Class`。
![img.png](img.png)

## 2. 反射之获取Class对象

### 获取`Class`对象的三种方式
1.  **方式1：调用`Object`类的`getClass()`方法**:
    Class<?> clazz = 对象.getClass();
2. **方式2：使用类的静态成员class
   基本类型和引用类型都支持，格式为**：Class<?> class = 类名.class;
3. **方式 3：调用Class类的静态方法forName()**:Class<?> clazz = Class.forName("类的全限定名");
  其中，参数是类的全限定名（即包名.类名）。

### 2.1 三种获取`Class`对象的方式中最`通用`的一种

1.  **核心方式**：方式 3：调用Class类的静态方法forName()**:Class<?> clazz = Class.forName("类的全限定名");
    其中，参数是类的全限定名（即包名.类名）。
2. 原因:String为参数时,可以结合Properties文件使用

### 2.2 三种获取`Class`对象的方式中最`常用`的一种
直接类名.class

## 3. 获取Class对象中的构造方法

### 3.1 获取所有public的构造方法
1.  Class类中的方法：
    ```java
    Constructor<?>[] getConstructors()//获取类中所有public修饰的构造方法
    
    ```

## 3.2 获取空参构造（public）

1. **Class类方法：获取指定public构造方法**
```java
    Constructor<T> getConstructor(Class<?>... parameterTypes);
```
- parameterTypes：可变参数，可传 0 个或多个 
  - 获取空参构造：不写参数
  - 获取有参构造：传入参数类型的 Class 对象
2. **Constructor 类方法：创建对象**
```java
    T newInstance(Object... initargs);
```
- initargs：构造方法的实参
    - 无参构造：不写参数
    - 有参构造：传入对应实参
- 示例
```java
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

## 3.3 获取私有构造(暴力反射)
1. **Class类方法：获取所有构造方法(包括私有)**
```java
    Constructor<?>[] getDeclaredConstructors();//获取类中所有构造方法(包括私有)
    Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes);//获取类中指定构造方法(私有也可以指定)
```
- parameterTypes：可变参数，可传 0 个或多个
    - 获取空参构造：不写参数
    - 获取有参构造：传入参数类型的 Class 对象
2. **暴力反射**:Constructor有一个父类叫做AccessibleObject,里面有个方法
- void setAccessible(boolean flag)->修改访问权限(暴力反射)
  - flag为true，接触私有权限