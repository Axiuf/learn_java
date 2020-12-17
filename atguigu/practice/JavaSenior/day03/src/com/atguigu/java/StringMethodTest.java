package com.atguigu.java;

import org.junit.Test;

import java.util.Locale;

/**
 * @author axiuf
 * @create 2020/12/16-22:37
 */
public class StringMethodTest
{
    @Test
    public void test1()
    {
        String s1 = "HelloWorld";
        System.out.println(s1.length());

        System.out.println(s1.charAt(0));
//        System.out.println(s1.charAt(4));
//        System.out.println(s1.charAt(9));
//        System.out.println(s1.charAt(10));

        System.out.println(s1.isEmpty());
//        System.out.println("".isEmpty());

        String s2 = s1.toLowerCase();
        System.out.println(s1);
        System.out.println(s2);

        String s3 = "    He   llo   Wo  r  l  d    ";
        String s4 = s3.trim(); // 去掉开头或者结尾的空格，中间的部分不变
        System.out.println("---" + s3 + "--- ");
        System.out.println("---" + s4 + "---");
    }

    @Test
    public void test2()
    {
        String s1 = "HelloWorld";
        String s2 = "HELLOWORLD";
        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s2));

        String s3 = "abc";
        String s4 = s3.concat("def");
        System.out.println(s4);

        String s5 = "abc";
        String s6 = new String("aba1234123213");
        System.out.println(s5.compareTo(s6)); // 依次比较字符串的每个字符，直到其中的一个不为0，输出前者减去后者的值

        String s7 = "北京尚硅谷教育";
        String s8 = s7.substring(4); // 返回左闭右开的区间
        System.out.println(s8);

        String s9 = s7.substring(2, 5);
        System.out.println(s9);
    }

    @Test
    public void test3()
    {
        String str1 = "helloWorld!";
        boolean b1 = str1.endsWith("ld!");
        System.out.println(b1);

        boolean b2 = str1.startsWith("He");
        System.out.println(b2);

        boolean b3 = str1.startsWith("ll", 2);
        System.out.println(b3);

        String str2 = "Wo";
        System.out.println(str1.contains(str2));

        System.out.println(str1.indexOf("lol"));
        System.out.println(str1.indexOf("ld", 5));

        System.out.println(str1.lastIndexOf("lo"));
        System.out.println(str1.lastIndexOf("el", 7));

        // 什么情况下，indexOf(str)和lastIndexOf(str)的返回值相同
        // 要么只有一个符合条件的str，要么就没有
    }

    @Test
    public void test4()
    {
        String str1 = "北北京尚硅谷教育北京";
        String str2 = str1.replace('北', '东');
        System.out.println(str1);
        System.out.println(str2);

        System.out.println(str1.replace("北京", "上海"));


    }
}