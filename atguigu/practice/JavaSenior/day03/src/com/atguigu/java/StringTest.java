package com.atguigu.java;

import org.junit.Test;

/**
 * String的使用
 *
 * @author axiuf
 * @create 2020/12/16-16:40
 */
public class StringTest
{
    /*
    String: 字符串，双引号表示，
    1. 声明为final，不可被继承
    2. 实现了Serializable接口，支持序列化；实现了Comparable接口，可以比较大小
    3. 内部定义了final char[] value用于存储字符串数据
    4. 代表不可变的字符序列，简称不可变性
        对字符串重新赋值时，需要重新指定内存区域赋值
        当调用String的replace修改指定的字符串时，也需要重新指定内存区域赋值，不能使用原有的value进行赋值
    5. 通过字面量的方式（区别于new）给一个字符串赋值，此时的字符串常量值声明在字符串常量池中
    6. 字符串常量池中是不会存储相同内容的字符串的

    内存空间中，方法区中包含字符串常量池，
     */
    @Test
    public void test1()
    {
        String s1 = "abc"; // 字面量的定义方式
        String s2 = "abc";
//        s1 = "hello";

        System.out.println(s1 == s2);

        System.out.println(s1);
        System.out.println(s2);

        System.out.println("****************");

        String s3 = "abc";
        s3 += "def";
        System.out.println(s3);

        String s4 = "abc";
        String s5 = s4.replace('a', 'm');
        System.out.println(s4);
        System.out.println(s5);
    }

    @Test
    public void test2()
    {
        // 通过字面量的方式定义，此时的s1和s2的值javaEE声明在方法区的字符串常量池中
        String s1 = "javaEE";
        String s2 = "javaEE";

        // 通过new + 构造器的方式，此时的s3和s4保存的是对象的地址值，是数据在堆空间中开辟空间以后对应的地址值
        String s3 = new String("javaEE");
        String s4 = new String("javaEE");

        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s4);
        System.out.println(s3 == s4);

        System.out.println("******");

        Person p1 = new Person("Tom", 12);
        Person p2 = new Person("Tom", 12);

        System.out.println(p1.name.equals(p2.name));
        System.out.println(p1.name == p2.name);

    }

    // 字面量赋值或者字面量的连接都是字面能量操作，赋值的都是字符串常量池中的对象，并且不会有任何相同的对象
    // 一旦直接涉及到变量的操作，则结果存在堆中。
    @Test
    public void test3()
     {
        String s1 = "javaEE";
        String s2 = "hadoop";

        String s3 = "javaEEhadoop";
        String s4 = "javaEE" + "hadoop";
        String s5 = s1 + "hadoop";
        String s6 = "javaEE" + s2;

        String s7 = s1 + s2;

        System.out.println(s3 == s4);
        System.out.println(s3 == s5);
        System.out.println(s3 == s6);
        System.out.println(s3 == s7);
        System.out.println(s5 == s7);

        String s8 = s5.intern(); // 返回值得到的s8是常量池中已经存在的"javaEE"
        System.out.println(s3 == s8);
    }
}