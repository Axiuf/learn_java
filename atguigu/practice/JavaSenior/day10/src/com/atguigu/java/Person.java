package com.atguigu.java;

import java.io.Serializable;

/**
 * Person类需要满足如下的要求才能序列化
 * 1. 需要实现接口：Serializable
 * 2. 需要当前类提供一个全局常量：
 *
 *
 *
 * @author Shan Cheng
 * @date 2020/12/25-12:33
 */
public class Person implements Serializable
{
    private String name;
    private int age;

    public static final long serialVersionUID = 4212009320918309182L;

    public Person()
    {
    }

    public Person(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    @Override
    public String toString()
    {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
