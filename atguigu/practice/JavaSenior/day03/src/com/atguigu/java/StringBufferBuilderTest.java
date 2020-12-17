package com.atguigu.java;

import org.junit.Test;

/**
 * @author axiuf
 * @create 2020/12/17-10:28
 */
public class StringBufferBuilderTest
{
    /**
    String、StringBuffer、StringBuilder三者的异同？
    String：不可变的字符序列，不可变，底层使用char型数组存储
    StringBuffer：可变的字符序列，线程安全的，效率低，底层使用char型数组存储
    StringBuilder：可变的字符序列，jdk5.0新增的，线程不安全，效率高，底层使用char型数组存储

    源码分析：
    String str = new String(); // char[] value = new char[0]
    String str1 = new String("abc"); // char[] value = new char[3]

    StringBuffer sb1 = new StringBuffer(); // char[] value = new char[16]
    sb1.append('a');
    sb1.append('b');

    StringBuffer sb2 = new StringBuffer("abc"); // char[] value = new char["abc".length() + 16]

    // 问题1. System.out.println(sb2.length()); 输出的实际的字符数量
    // 问题2. 默认情况下，扩容为原来容量的2倍 + 2，同时将原有数组中的元素复制到新的数组中

        指导意义，开发中建议使用StringBuffer(int capacity)避免扩容复制 或者 String Builder(int capacity)，根据
        是否需要线程安全来选择

     总结：增删改查
     增：append()
     删：delete()
     该；setChatAt()、replace()
     查：charAt()
     插：insert()
     长度：length()
     遍历：for() + charAt()

     */

    @Test
    public void test1()
    {
        StringBuffer sb1 = new StringBuffer("abc");
        sb1.setCharAt(0, 'm');
        System.out.println(sb1);

        StringBuffer sb2 = new StringBuffer();
        System.out.println(sb2.length());
    }

    @Test
    public void test2()
    {
        StringBuffer s1 = new StringBuffer("abc");
        s1.append(1);
        s1.append('1');
        System.out.println(s1);

//        s1.delete(2, 4);
        System.out.println(s1); // 左闭右开

        s1.replace(2, 4, "hell0");
        System.out.println(s1);

        s1.insert(2, false);
        System.out.println(s1);
        System.out.println(s1.length());

        s1.reverse();
        System.out.println(s1);
        System.out.println(s1.substring(1, 3));
        System.out.println(s1.charAt(0));
        System.out.println(s1.indexOf("ll"));

        String.valueOf(1);
    }
}
