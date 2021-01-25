package com.atguigu.java;

import org.junit.Test;

import java.awt.desktop.SystemSleepEvent;
import java.util.Date;

/**
 * JDK 8 之前的日期和时间的API测试
 *
 * @author axiuf
 * @create 2020/12/17-13:14
 */
public class DateTimeTest
{
    @Test
    public void test1()
    {
        // 返回1970年1月1日0时0分0秒到目前的以毫秒为单位的时间差，常用用来可以做时间戳
        long time = System.currentTimeMillis();
        System.out.println(time);

        System.out.println(System.currentTimeMillis());
        System.out.println(System.currentTimeMillis());
        System.out.println(System.currentTimeMillis());
        System.out.println(System.currentTimeMillis());
    }

    @Test
    public void test2()
    {
        // Date() 创建一个对应当前时间的构造器
        Date date1 = new Date();
        System.out.println(date1.toString()); // Thu Dec 17 13:20:30 CST 2020

        System.out.println(date1.getTime()); // getTime获取当前Date对象的毫秒数，或者说时间戳

        // 创建指定毫秒数的Date对象
        Date date2 = new Date(1608182481340L);
        System.out.println(date2.toString());

        // 如何实例化
        // sql.Date --> util.Date 直接赋值，多态(sql.Date继承了util.Date
        //
        java.sql.Date date3 = new java.sql.Date(1608182481340L);
        System.out.println(date3.toString());

        Date date4 = new java.sql.Date(1608182481340L);
        java.sql.Date date5 = (java.sql.Date) date4;

        Date date6 = new Date();
        java.sql.Date date7 = new java.sql.Date(date5.getTime());

    }
}