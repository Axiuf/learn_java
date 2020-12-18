package com.atguigu.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * java中的对象，正常情况下只能进行比较：== 或是 != 。不能使用 > 或是 < 的比较
 * 但是实际的开发中，我们需要对多个对象进行排序，言外之意，就需要比较对象的大小？
 * 如何实现？使用两个接口中的任何一个：Comparable 或者 Comparator
 *
 * @author axiuf
 * @create 2020/12/18-14:19
 */
public class CompareTest
{

    /**
     * Comparable接口的使用举例：
     * 1. 像String、包装类等实现了Comparable接口，重写了compareTo()方法，给出了比较两个对象大小的方法
     * 2. String、包装类重写了CompareTo()方法后是实现了从小到大的排列的。
     * 3. 重写compareTo的规则：
     *  如果当前this对象大于形参obj，则返回正整数
     *  如果当前this对象小于形参obj，则返回负整数
     *  如果当前this对象等于形参obj，则返回0
     *
     *  4. 对于自定义类，要排序，可以让自定义类实现Comparable接口，重写CompareTo()方法看，称为自然排序
     */
    @Test
    public void test1()
    {
        String[] arr = new String[]{"AA", "GG", "FF", "SS", "KK", "EE", "BB"};
        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));

    }

    @Test
    public void test2()
    {
        Goods[] arr = new Goods[4];
        arr[0] = new Goods("lenovoMouse", 94);
        arr[1] = new Goods("dellMouse", 14);
        arr[2] = new Goods("xiaomiMouse", 44);
        arr[3] = new Goods("huaweiMouse", 14);

        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));
    }

    /**
     * Comparator出现的背景：定制排序
     * 1. 背景：元素的类型没有实现Comparable接口而又不方便修改代码
     *  实现了java.lang.Comparable接口但是不符合目前的要求
     *
     *  2. compare()方法
     */
    @Test
    public void test3()
    {
        String[] arr = new String[]{"AA", "GG", "FF", "SS", "KK", "EE", "BB"};
        Arrays.sort(arr, new Comparator()
        {
            @Override
            public int compare(Object o1, Object o2)
            {
                if (o1 instanceof String && o2 instanceof String)
                {
                    String str1 = (String) o1;
                    String str2 = (String) o2;
                    return -str1.compareTo(str2);
                }
                throw new RuntimeException("输入的数据类型不一致");
            }
        });

        System.out.println(Arrays.toString(arr));

    }
}
