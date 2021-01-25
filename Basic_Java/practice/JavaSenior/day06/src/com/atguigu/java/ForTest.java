package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * jdk5.0中新增了foreach循环，用于遍历集合、数组
 *
 * @author axiuf
 * @create 2020/12/20-16:43
 */
public class ForTest
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


        // for(集合对象）内部仍然调用迭代器
        for (Object obj : coll)
        {

        }
    }
}
