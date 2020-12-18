package com.atguigu.java;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * @author axiuf
 * @create 2020/12/18-10:25
 */
public class JDK8DateTimeTest
{
    @Test
    public void testDate()
    {
        // 偏移量：要以1900年1月1号为起点，同时月份起点为0
        Date date1 = new Date(2020 - 1900, 12 - 1, 18);
        System.out.println(date1);
    }

    /*
    LocalDate（年月日） LocalTime（时分秒） LocalDateTime的使用
     */
    @Test
    public void test()
    {
        // now()：获取当前的日期、时间、日期+时间
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        // of()：设置指定的年、月、日、时、分、秒。没有偏移量。
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 12, 18, 10, 39, 10);
        System.out.println(localDateTime1);

        // getXxx()：获取相关的属性变量
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfYear());
        System.out.println(localDateTime.getMinute());
        System.out.println(localDateTime.getSecond());

        // withXxx()：设置相关的属性变量
        LocalDate localDate1 = localDate.withDayOfMonth(22);
        System.out.println(localDate1);
        System.out.println(localDate);

        // plusXxx()：对应的属性减去
        // minusXxx()：对应的属性加上
        // 这里有个不可变性，对原变量的操作都会反应在返回一个新的值
    }

    /*
    DateTimeFormatter：格式化或者解析日期、时间
     */
    @Test
    public void test3()
    {
        // 方式一：预定义的标准格式
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

        // 格式化：日期-->字符串
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        String string1 = formatter.format(localDateTime);
        System.out.println(string1);

        // 解析：字符串-->日期
        TemporalAccessor parse = formatter.parse("2020-12-18T13:28:23.7578747");
        System.out.println(parse);

        // 方式二：本地化相关的格式
        // ofLocalizedDateTime()
        // FormatStyle.LONG /FormatStyle.SHORT/FormatStyle.MEDIUM
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        String str2 = formatter1.format(localDateTime);
        System.out.println(str2);

        // 本地化相关的格式
        // ofLocalizedDate()
        // FormatStyle.LONG /FormatStyle.SHORT/FormatStyle.MEDIUM
        DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        String str3 = formatter2.format(LocalDate.now());
        System.out.println(str3);

        // 方式三：自定义的格式。如：ofPattern("yyyy-MM-dd")
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        System.out.println(formatter3.format(LocalDateTime.now()));

        System.out.println(formatter3.parse("2020-12-18 01:42:20"));


    }
}
