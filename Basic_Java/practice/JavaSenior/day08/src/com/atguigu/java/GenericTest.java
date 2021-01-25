package com.atguigu.java;

import org.junit.Test;

import java.util.*;

/**
 * 泛型的使用
 * 1. jdk 5.0新增的特性
 *
 * 2. 在集合中使用泛型
 *      1. 集合接口或集合类在jdk5.0时都修改为带泛型的结构
 *      2. 在实例化集合是，可以指明具体的泛型类型
 *      3. 指明完以后，在集合类或者接口中凡是定义类或者接口时，内部结构（比如：方法、构造器、属性）使用到类的泛型的位置，
 *         都指定为泛型的类型
 *      4. 注意点：泛型的类型必须是类，不能是基本数据类型，需要用到基本数据类型的位置，都使用对应的包装类
*       5. 如果实例化时，没有指明泛型的类型，默认类型为java.lang.Object类型
 *
*  3. 如何自定义泛型类，接口，方法
 *
 *
 * @author Shan Cheng
 * @date 2020/12/22-10:18
 */
public class GenericTest
{
    @Test
    public void test1()
    {
        ArrayList list = new ArrayList();

        // 需求：存放学生的成绩
        list.add(78);
        list.add(76);
        list.add(89);
        list.add(88);

        // 问题一：类型不安全
        list.add("Tom");

        for (Object score : list)
        {
            // 强转时， 可能出出现ClassCastException
            int stuScore = (int) score;
            System.out.println(stuScore);
        }

    }

    // 集合中使用泛型的情况：以ArrayList为例
    @Test
    public void test2()
    {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(78);
        list.add(68);
        list.add(28);
        list.add(93);
        // 编译时，就会类型检查，保证数据的安全
//        list.add("Tom");

        for (Integer score : list)
        {
            // 避免了强转操作
            int stuScore = score;
            System.out.println(stuScore);
        }

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            int stuScore = iterator.next();
            System.out.println(stuScore);
        }
    }

    // 集合中泛型的使用，以HashMap为例
    @Test
    public void test3()
    {
        Map<String, Integer> map = new HashMap<String, Integer>();

        map.put("Tom", 87);
        map.put("Harry", 87);
        map.put("Jack", 33);

        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
        while(iterator.hasNext())
        {
            Map.Entry<String, Integer> next = iterator.next();
            System.out.println(next.getKey());
            System.out.println(next.getValue());
        }
    }
}
