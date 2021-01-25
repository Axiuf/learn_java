package com.atguigu.java;

import org.junit.Test;

import java.util.Optional;

/**
 * @author Shan Cheng
 * @date 2020/12/28-10:32
 */
public class OptionalTest
{
    @Test
    public void test1()
    {
        Optional<Object> op1 = Optional.empty();

        if (!op1.isPresent()) // 这个封装的数据是否是null
        {
            System.out.println("数据为空");
        }

        // 如果Optional封装的数据value为空，调用get()方法会报错
//        System.out.println(op1.get());
        System.out.println(op1.isPresent());
    }

    @Test
    public void test2()
    {
        String str = "hello";
        str = null;
        // of(T t): 封装数据对象要求非空，否则报错
        Optional<String> op1 = Optional.of(str);

        System.out.println(op1.get());
    }

    @Test
    public void test3()
    {
        String str1 = "Beijing";
        str1 = null;
        Optional<String> op1 = Optional.ofNullable(str1); // 封装数据赋值给Optional内部的value，不要求t非空

        String str2 = op1.orElse("Shanghai"); // orElse提供内部为null的的替代值
        System.out.println(str2);
    }
}