package com.atguigu.java;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author axiuf
 * @create 2020/12/17-23:00
 */
public class DateTimeTest
{
    @Test
    public void testSimpleDateFormat()
    {
        // 实例化SimpleDateFormat对象：这里是使用默认的构造器。这个对象其实只是一个格式转换器，本身不包含日期的信息
        SimpleDateFormat sdf = new SimpleDateFormat();

        // 格式化：日期 ---> 字符串
        Date date = new Date();
        System.out.println(date);
        System.out.println(date.getTime());

        String format = sdf.format(date);
        System.out.println(format);

        // 解析：格式化的逆过程，字符串 ---> 日期
        String str = "2020/12/17 上午11:12";
        try
        {
            Date date1 = sdf.parse(str);
            System.out.println(date1);
        } catch (ParseException e)
        {
            e.printStackTrace();
        }

        // 按照指定的方式格式化和解析：调用带参数的构造器
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
        System.out.println(sdf1.format(date));

    }

    /*
    练习一：字符串"2020-09-08"转换为java.sql.Date
     */
    @Test
    public void test2() throws ParseException
    {
        String birth = "2020-12-17";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date date = sdf.parse(birth);

        java.sql.Date birthDate = new java.sql.Date(date.getTime());
        System.out.println(birthDate);
    }

    /*
    Calender日历类的使用
     */
    @Test
    public void test3()
    {
        // 1.实例化
        // 方式一：创建其子类的对象
        // 方式二：调用其静态方法getInstance()
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getClass());

        // 2.常用的方法
        // get()
        int days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
        // set()
        calendar.set(Calendar.DAY_OF_YEAR, 22);
        days = calendar.get(Calendar.DAY_OF_YEAR);
        System.out.println(days);
        // add()
        calendar.add(Calendar.DAY_OF_YEAR, 3);
        days = calendar.get(Calendar.DAY_OF_YEAR);
        System.out.println(days);
        // getTime()
        Date date = calendar.getTime();
        System.out.println(date);
        // setTime()
        Date date1 = new Date();
        calendar.setTime(date1);
        System.out.println(date1);
    }

}
