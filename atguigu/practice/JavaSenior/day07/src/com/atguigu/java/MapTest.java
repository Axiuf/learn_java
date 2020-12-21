package com.atguigu.java;

import org.junit.Test;

import java.util.*;

/**
 * |----Map: 双列数据，存储key-value对的数据
 *  |---HashMap 作为Map的主要实现类，线程不安全，效率高，存储null的key和value
 *
 *      |---LinkedHashMap 能够保证遍历Map元素时是按照添加的顺序实现的。是在原有的HashMap的基础上添加了一对指针
 *                          对于频繁的遍历操作，此类执行效率高于HashMap
*   |---TreeMap 保证按照天机的key-value对进行排序，实现排序遍历（这里是按照key）来排序。此时考虑key的自然排序或定制排序
 *                  底层使用的是红黑树（和TreeSet一样）
 *  |---Hashtable 作为古老的实现类，线程安全的，效率低，不能存储null的key和value
 *      |---Properties 常用来处理配置文件，key和value都是String类型
 *
 * HashMap底层最初的时候就是数组+链表 （jdk7及之前）
 *                         数组+链表+红黑树 （jdk8）
 *
 * 面试题：
 * 1. HashMap的底层实现原理？
 *
 * 2. HashMap和hashTable的异同？
 *
 * 3. CurrentHashMap与 HashTable的异同？
 *
 * 二、 Map结构的理解
 * Map中的key：无序的、不可重复的，使用Set存储所有的key  ————> key所在的类要重写equals()和hashCode() 以HashMap为例
 * Map中的value：无序的、不可重复的，使用Collection存储所有的value ————> value所在的类要重写equals()方法
 *
 * 一个键值对构成了一个Entry对象
 * Map中的Entry：无序的、不可重复的，使用Set存储所有的entry
 *
 * 三、HashMap的底层实现原理？ jdk7：
 *  HashMap map = new HashMap();
 *  实例化之后，底层创建了长度是16的一维数组Entry[] table
 *  map.put(key1, value1)
 *  可能已经执行过多次put()
 *
 *  不同的数据有可能会获得相同的Hash值，但是确定的hash值一定会对应确定的地址值，一般情况下不同对象都不相同
 *  所以首先根据hash值计算地址值，地址值上有相同的了再来看hash值是否一样
 *
 *  首先调用key1所在类的HashCode()计算key1的哈希值，此哈希值经过某种算法计算以后，得到在Entry数组中的存放位置
 *  如果此位置上的数据为空，此时的key1-value添加成功。---情况1
 *  如果此位置上的数据不为空，意味着此位置存在一个或者多个数据（以链表的形式存在），比较当前的key1和已经存在的一个或者
 *  多个数据的hash值，
 *      如果key1的哈希值与已经存在的数据的哈希值都不相同，此时key1-value1添加成功   ---情况2
 *      如果key1的哈希值和已经存在的某一个数据的哈希值相同，继续比较，调用key1所在类的equals()方法，比较：
 *          如果equals()返回false：此时key1-value1添加成功  ---情况3
 *          如果equals()返回true：使用value1替换value2。
 *  补充：关于情况2和3：此时key1-value1和原来的数据以及链表的方式存储
 *
 *  扩容问题，默认的扩容方式：扩容为原来容量的两倍
 *
 *  jdk8 相比较于jdk7在底层实现方面的不同：
 *      new HashMap(): 底层没有创建一个长度为16的数组
 *      jdk 8底层的数组是：Node[] 而不是Entry[]
 *      首次调用put()方法时，底层创建长度为16的数组
 *      jdk7底层结构只有：数组+链表。jdk8中底层结构：数组+链表+红黑树
 *      当数组的某一个索引位置上的元素以链表形式存在的数据个数 > 8 且当前数组长度 > 64 时，
 *      此时此索引位置上的所有数据改为使用红黑树存储。
 *
 * @author Shan Cheng
 * @date 2020/12/21-19:18
 */
public class MapTest
{
    @Test
    public void test1()
    {
        Map map = new HashMap();

        // 添加
        map.put("AA", 123);
        map.put("45", 123);
        map.put("BB", 123);

        // 修改 如果key值相同，就会覆盖掉之前的value
        map.put("AA", 87);
        System.out.println(map);

        Map map1 = new HashMap();
        map1.put("CC", 123);
        map1.put("DD", 123);

        // 添加所有
        map.putAll(map1);
        System.out.println(map);

        // 移除指定的key的数据
        Object value = map.remove("CC");
        System.out.println(value);
        System.out.println(map);

        // 移除所有的数据
        map.clear();
        System.out.println(map);
        System.out.println(map.size());
    }

    @Test
    public void test2()
    {
        Map map = new HashMap();
        map.put("AA", 123);
        map.put(45, 123);
        map.put("BB", 56);

        // 获取指定的key的value值
        System.out.println(map.get(45));

        // 查询存在是否存在指定的key或者value
        System.out.println(map.containsKey(45));
        System.out.println(map.containsValue(123));
    }

    @Test
    public void test3()
    {
        Map map = new HashMap();
        map.put("AA", 123);
        map.put(45, 123);
        map.put("BB", 56);

        // 找到所有的key作为一个Set
        Set set = map.keySet();
        System.out.println(set);

        // 找到所有的value作为一个Collection
        Collection values = map.values();
        System.out.println(values);

        // 找到素有的key-value作为包含所有的entry的Set
        System.out.println(map.entrySet());
    }
}