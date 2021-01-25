package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 总结下常用方法：所有的Array的地方，都可以替换为ArrayList
 * 增 add()
 * 删 remove(Object obj) remove(int Index)
 * 改 set()
 * 查 get()
 * 插 add(int Index, Object obj)
 * 长度 size()
 * 遍历 Iterator迭代器、增强for循环、普通循环
 *
 *
 * 我们向HashSet中添加元素a，首先调用元素a所在类的hashCode()方法，计算元素a的哈希值，此哈希值接着通过某种
 * 算法计算出在HashSet中的存放位置（即为：索引位置）。判断内部的数组在此位置上是否已经有元素，
 *  如果此位置上没有其他元素，则元素a添加成功，
 *  如果此位置上有其他元素b（或者以链表形式存在的多个元素），则比较元素a和元素b的hash值，
 *      如果hash值不相同，则元素a添加成功，
 *      如果hash值不同，进而需要调用元素a所在类的equals()方法，
 *          如果equals()返回true，则元素a添加失败
 *          如果equals()返回false，则元素a添加成功
 *
 *      对于添加成功的情况而言：元素a和已经存在指定索引位置上的元素以链表的形式存储
 *      对于jdk7，新元素作为链表的头，存放在指定的索引
 *      对于jdk8，新元素作为链表的尾
 *      总结一下即 7上8下
 *
 *
 * @author Shan Cheng
 * @date 2020/12/20-22:45
 */
public class ListTest
{
    @Test
    public void test()
    {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AAA");
        list.add(new Person("Shan", 25));

        System.out.println(list);

        // add() 在对应的位置添加元素
        list.add(1, "BB");
        System.out.println(list);

        // addAll(index, Collection else) 在对应的位置开始，把else中的所有元素加到对应的位置
        List list1 = Arrays.asList(1, 2, 3);
        list.addAll(list1);
        System.out.println(list.size());

        // get() 获取对应位置的元素
        System.out.println(list.get(0));
    }

    @Test
    public void test2()
    {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AAA");
        list.add(new Person("Shan", 25));
        list.add(456);

        // indexOf() 取得对应元素位置的下标，首次出现的位置，没有返回-1
        int index = list.indexOf(456);
        System.out.println(index);

        // lastIndexOf(Object obj) 返回对应的元素最后一次出现的位置
        System.out.println(list.lastIndexOf(456));

        // remove(int index) 删除对应下标的元素，并且返回这个值
        Object obj = list.remove(0);
        System.out.println(list);
        System.out.println(obj);

        // set(int index, Object obj) 设置对应位置的元素为指定值


        // List subList(int fromIndex, int toIndex) 返回左闭右开的子集，不会对本身的值造成影响

    }

    @Test
    public void test3()
    {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AAA");
        list.add(new Person("Shan", 25));
        list.add(456);

        Iterator iterator = list.iterator();
        while (iterator.hasNext())
        {
            System.out.println(iterator.next());
        }

        for (Object obj : list)
        {
            System.out.println(obj);
        }
    }


}
