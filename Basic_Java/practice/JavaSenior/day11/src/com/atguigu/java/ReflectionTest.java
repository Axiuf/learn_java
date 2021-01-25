package com.atguigu.java;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Shan Cheng
 * @date 2020/12/26-11:22
 */
public class ReflectionTest
{
    // 反射之前，对Person的操作
    @Test
    public void test1()
    {
        // 1. 创建Person类的对象
        Person p1 = new Person();

        // 2. 通过对象，调用其内部的属性和方法
        p1.age = 10;
        System.out.println(p1.toString());

        p1.show();

        // 在Person类的外部，不可以通过Person类的对象调用其内部的私有结构
        // 比如name、shouNation()以及私有的构造器
    }

    // 反射之后，对于Person的操作
    @Test
    public void test2() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException
    {
        Class personClass = Person.class;

        // 1. 通过反射，创建Person类的对象
        Constructor cons = personClass.getConstructor(String.class, int.class);

        Object obj = cons.newInstance("Tom", 12);

        Person p = (Person) obj;
        System.out.println(p.toString());

        // 2. 通过反射，调用对象指定的属性、方法
        Field age = personClass.getDeclaredField("age");
        age.set(p, 10);
        System.out.println(p.toString());

        // 调用方法
        Method show = personClass.getDeclaredMethod("show");
        show.invoke(p);

        // 通过反射，可以调用Person类的私有结构，比如，私有的构造器，方法，属性
        Constructor cons1 = personClass.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Object p1 = cons1.newInstance("Jerry");
        System.out.println(p1);

        // 调用私有的属性
        Field name = personClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1, "HanMei");
        System.out.println(p1);

        // 调用私有的方法
        Method showNation = personClass.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(p1, "China");// 相当于p1.showNation("China")
        System.out.println(nation);
    }

    // 疑问：通过直接new的方式或者反射的方式都可以调用公共的结构，到底用哪个？
    // 建议：直接new的方式
    // 什么时候会使用：反射的方式。反射的特征：动态性
    // 疑问2：反射机制与面向对象中的封装性是不是矛盾的？如何看待两个技术
    // 不矛盾。

    /*
    关于java.lang.Class类的理解
    1. 类的加载过程：
        程序经过javac.exe命令后，会生成一个或者过个字节码文件（.class结尾），接着我们使用java.exe命令对某个字节码文件
        进行解释运行。相当于将某个字节码文件加载到内存中。此过程就称之为类的加载。加载到内存中的类，我们就称之为运行时
        类，此运行时类，就作为Class的一个实例。
    2. 换句话说，Class的实例就对应这一个运行时类

    3. 加载到内存中的运行时类，会缓存一定的时间。在此时间之内，我们可以通过不同方式来获取此运行时类
    // 获取Class的实例的方式（前三种方式需要掌握）
     */

    @Test
    public void test3() throws ClassNotFoundException
    {
        // 方式一：调用运行时类的属性：.class
        Class<Person> aClass1 = Person.class;
        System.out.println(aClass1);

        // 方式二：通过运行时类的对象 getClass()
        Person person = new Person();
        Class<? extends Person> aClass2 = person.getClass();
        System.out.println(aClass2);

        // 方式三：调用Class的静态方法：forName(String classPath)
        Class<?> aClass3 = Class.forName("com.atguigu.java.Person");
        System.out.println(aClass3);

        System.out.println(aClass1 == aClass2 && aClass1 == aClass3);

        // 方式四：使用类的加载器：ClassLoader （了解）
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class<?> aClass4 = classLoader.loadClass("com.atguigu.java.Person");
        System.out.println(aClass4);
    }

    // 万事万物皆对象？对象.xxx, File, URL, 反射，前端，数据库操作
}
