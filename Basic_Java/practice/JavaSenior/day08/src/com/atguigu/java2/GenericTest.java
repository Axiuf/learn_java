package com.atguigu.java2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 *
 * @author Shan Cheng
 * @date 2020/12/22-15:26
 */
public class GenericTest
{
    /*
    1. 泛型在继承方面的体现
    虽然类A是类B的父类，G<A> 和 G<B> 二者不具备子父类的关系

    补充：类A是类B的父类，A<G>， B<G>

     */
    @Test
    public void test1()
    {
        Object obj = null;
        String str = null;

        obj = str;

        Object[] arr1 = null;
        String[] arr2 = null;
        arr1 = arr2;

        List<Object> list1 = null;
        List<String> list2 = null;
        // 此时的list1和list2不具有子父类的关系，编译不通过
//        list1 = list2;

//        Date date = new Date();
//        str = date;

        /*
        反证法：
        假设list1 = list2;
            lsit1.add(123) 会导致混入非String的关系
         */
    }

    @Test
    public void test2()
    {
        List<String> list = new ArrayList<String>();
        list.add("aa");

        List<?> list1;
        list1 = list;
        Object o = new Object();
//        list1.add(o);
    }

    @Test
    public void test3()
    {
        List<Object> list1 = null;
        List<String> list2 = null;

        List<?> list = null;

        list = list1;
        list = list2;
    }
}
