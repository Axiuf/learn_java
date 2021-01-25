package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 集合元素的遍历，使用Iterator接口，拿到的iterator类似一个指针的变量，只要用指针的概念去理解这个事情就还好
 * Next() 和 hasNext() 方法
 *
 * 内部定义了remove()方法，可以在遍历的时候删除集合中的元素，与集合直接掉用
 *
 * @author axiuf
 * @create 2020/12/20-15:33
 */
public class IteratorTest
{
    @Test
    public void test1()
    {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Cheng", 25));
        coll.add(new String("这是一个测试"));
        coll.add(false);

        Iterator iterator = coll.iterator();
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());

        for (int i = 0; i < coll.size(); i++)
        {
            System.out.println(iterator.next());
        }

        while (iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test3()
    {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Cheng", 25));
        coll.add(new String("这是一个测试"));
        coll.add(false);

        // 删除集合中的元素
        Iterator iterator = coll.iterator();
        while (iterator.hasNext())
        {
            Object obj = iterator.next();
            if ("这是一个测试".equals(obj))
            {
                iterator.remove();
            }
        }
    }

    @Test
    public void test4()
    {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Cheng", 25));
        coll.add(new String("这是一个测试"));
        coll.add(false);

        System.out.println(coll);
//        coll.remove("这是一个测试");
//        System.out.println(coll);

        Iterator iterator = coll.iterator();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.remove();
        System.out.println(coll);

    }
}
