package com.atguigu.java1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * 一、集合框架的概述
 * 1. 集合和数组都是对多个数据进行存储操作的结构，简称Java容器
 *  说明：此时的存储，主要指的是内存层面的存储，不涉及到持久化的存储（.txt, .jpg, .avi, 数据库等）
 *
 * 2.1 数组在存储多个数据方面的特点
 *  数组一旦初始化之后，其长度就确定了
 *  比如String[] arr, int[] arr1, 并且一旦定义好，其元素的类型也定义好了，我们只能去操作指定类型的数据
 *  （当然这里存在多态的一些可能性）
 *
 *  2.2 数组在存储多个数据方面的缺点：
 *      一旦初始化之后，长度确定之后就不可修改了
 *      数组中提供的方法非常有限，对于添加，删除，或是插入数据的操作非常不便
 *      获取数组中实际元素的个数，数组没有现成的属性或者方法可以用
 *      数组存储数据的特点：有序的、并且可以有重复的数组。对于无序的，不可重复的需求，不能满足
 *
 * 二、集合框架
 *  |---Collection接口：单列集合，存储一个个的对象
 *      |---List接口：存储有序的、可重复的数据 “动态”数组
 *          |---ArrayList, LinkedList, Vector
 *      |---Set接口：存储无序的、不可重复的数据
 *          |---HashSet, LinkedHashSet, TreeSet
 *
*   |---Map接口：双列结合，用来存储一对（key-value）一对的数据
 *      |---HashMap, LinkedHashMap, TreeMap, HashTable, Properties
 *
 *
 * @author axiuf
 * @create 2020/12/19-10:15
 */
public class CollectionTest
{
    @Test
    public void test1()
    {
        Collection coll = new ArrayList();

        // add(Object e) 将元素添加到集合中
        coll.add("AA");
        coll.add("BB");
        coll.add(123); // 自动装箱
        coll.add(new Date());

        // size() 获取添加的元素个数
        System.out.println(coll.size());

        // addAll() 将coll1集合中的元素添加到当前的集合中
        Collection coll1 = new ArrayList();
        coll1.add(456);
        coll1.add("CC");
        coll1.addAll(coll1);

        System.out.println(coll.size());
        System.out.println(coll);

        // clear() 清空集合元素
        coll.clear();

        // isEmpty() 判断集合是否为空
        System.out.println(coll.isEmpty());


    }
}
