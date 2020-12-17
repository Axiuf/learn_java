package com.atguigu.java;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @author axiuf
 * @create 2020/12/16-23:35
 */
public class StringTest1
{
    /*
    复习：
    String：与基本数据类型、包装类之间的转换
    String --> 基本数据类型、包装类：调用包装类的静态方法：parseXxx(str)

    基本数据类型、包装类 --> String：顶用String重载的valueOf(xxx)
     */

    @Test
    public void test1()
    {
        String str1 = "123";
//        int num = (int) str1;
        int num = Integer.parseInt(str1);

        String str2 = String.valueOf(num); // "123"
        String str3 = num + "";

        System.out.println(str1);
        System.out.println(num);
        System.out.println(str2);
        System.out.println(str3);
        System.out.println(str1 == str3);

    }

    // String 和 char[] 之间的转换
    // toCharArray()方法
    // 直接调用构造器
    @Test
    public void test2()
    {
        String str1 = "abc123";
        char[] charArray = str1.toCharArray();
        for (int i = 0; i < charArray.length; i++)
        {
            System.out.println(charArray[i]);
        }

        char[] arr = new char[]{'h', 'e', 'l', 'l', 'o'};
        String str2 = new String(arr);
        System.out.println(str2);
    }

// 调用String的getBytes()
    @Test
    public void test3() throws UnsupportedEncodingException
    {
        String str1 = "abc123中国";

        byte[] bytes = str1.getBytes();
        System.out.println(Arrays.toString(bytes));

//        char[] a = new char[]{'1', '2', '4', '2', '1', '2'};
//        System.out.println(Arrays.toString(a));


        byte[] gbks = str1.getBytes("gbk");
        System.out.println(gbks);
        System.out.println(Arrays.toString(gbks));
    }

    @Test
    public void test4()
    {
        String s1 = "javaEEhadoop";
        String s2 = "javaEE";
        String s3 =  s2 + "hadoop";
        System.out.println(s1 == s3);

        final String s4 = "javaEE"; // s4 常量
        String s5 = s4 + "hadoop";
        System.out.println(s1 == s5);
    }
}