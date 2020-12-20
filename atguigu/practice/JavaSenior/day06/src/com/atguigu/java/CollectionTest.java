package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Collection接口中声明的一些方法的测试
 * 添加自定义的类的实例时，一般要自己重写equals方法
 *
 * @author axiuf
 * @create 2020/12/19-22:51
 */

public class CollectionTest
{
    @Test
    public void test1()
    {
        Collection coll = new ArrayList();
        coll.add(new Person("Cheng", 25));
        Person p = new Person("Cheng", 25);
        coll.add(p);
        coll.add(123);
        coll.add(456);
        coll.add(new String("这是一个测试"));
        coll.add(false);

        // contains(Object obj) 判断当前的集合中是否包含obj，调用的方法为equals()，要求自己先重写equals()
        System.out.println(coll.contains(123));
        System.out.println(coll.contains(new String("这是一个测试")));
        System.out.println(coll.contains(p));
        System.out.println(coll.contains(new Person("Cheng", 25)));

        // containsAll(Collection coll1) 判断形参coll1中的所有元素是否都存于当前的集合中
        Collection coll1 = Arrays.asList(123, 4567);
        System.out.println(coll.containsAll(coll1));
    }

    @Test
    public void test2()
    {
        // remove(Object obj) 从当前的集合中删除obj元素。
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Cheng", 25));
        coll.add(new String("这是一个测试"));
        coll.add(false);

        System.out.println(coll.remove(1234));
        System.out.println(coll);

        coll.remove(new Person("Cheng", 25));
        System.out.println(coll);

        // removeAll(Collection coll1) 从当前的集合中移除coll1中所有的元素
        Collection coll1 = Arrays.asList(123, 4567);
        System.out.println(coll.removeAll(coll1));
        System.out.println(coll);
    }

    @Test
    public void test3()
    {
        // remove(Object obj) 从当前的集合中删除obj元素。
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Cheng", 25));
        coll.add(new String("这是一个测试"));
        coll.add(false);

//        // coll.retainAll() 获取当前集合和coll1集合的交集，并返回给当前集合
//        Collection coll1 = Arrays.asList(123, 456, 789);
//        System.out.println(coll.retainAll(coll1));
//        System.out.println(coll);

        // equals(Object obj)：判断当前集合和指定集合是否相同，实际上是对每个位置上的元素一一进行equals判断
        Collection coll1 = new ArrayList();
        coll1.add(123);
        coll1.add(456);
        coll1.add(new String("这是一个测试"));
        coll1.add(new Person("Cheng", 25));
        coll1.add(false);

        System.out.println(coll.equals(coll1));
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

        // hashCode() 返回当前对象的哈希值
        System.out.println(coll.hashCode());

        // toArray() 集合转换为数组
        Object[] arr = coll.toArray();
        for (int i = 0; i < arr.length; i++)
        {
            System.out.println(arr[i]);
        }

        // 数组转换为集合：调用Arrays类的静态方法asList(), 基本类型的数组被识别为单个数组元素
        List<String> list = Arrays.asList(new String[]{"AA", "BB", "CC"});
        System.out.println(list);

        List arr1 = Arrays.asList(new Integer[]{123, 456});
        System.out.println(arr1.size());

        List arr2 = Arrays.asList(new Integer[]{123, 456});
        System.out.println(arr2.size());

        // iterator()：返回Iterator接口的实例，用于遍历结合元素。放在IteratorTest.java中
    }
}