package com.atguigu.exer;

import org.junit.Test;

import java.util.Collection;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author Shan Cheng
 * @date 2020/12/21-15:49
 */
public class EmployeeTest
{
    @Test
    public void test1()
    {
        Collection collection = new TreeSet<Employee>();

        collection.add(new Employee("Shan", 15, 1995, 6, 5));
        collection.add(new Employee("Xin", 45, 1595, 6, 5));
        collection.add(new Employee("Ma", 15, 1995, 4, 5));
        collection.add(new Employee("He", 25, 1995, 6, 5));
        collection.add(new Employee("Wen", 15, 1995, 6, 9));

        for (Object e : collection)
        {
            System.out.println(e);
        }
    }

    @Test
    public void test2()
    {
        Collection collection = new TreeSet(new Comparator()
        {
            @Override
            public int compare(Object o1, Object o2)
            {
                if (o1 instanceof Employee && o2 instanceof Employee)
                {
                    Employee e1 = (Employee) o1;
                    Employee e2 = (Employee) o1;
                    return e1.getBirthday().compareTo(((Employee) o2).getBirthday());
                }

                throw new RuntimeException("数据类型错误");
            }
        });

        collection.add(new Employee("Shan", 15, 1995, 6, 5));
        collection.add(new Employee("Xin", 45, 1595, 6, 1));
        collection.add(new Employee("Ma", 15, 1995, 4, 5));
        collection.add(new Employee("He", 25, 1995, 6, 12));
        collection.add(new Employee("Wen", 15, 1995, 6, 9));

        for (Object e : collection)
        {
            System.out.println(e);
        }
    }
}