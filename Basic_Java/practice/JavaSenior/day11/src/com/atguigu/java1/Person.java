package com.atguigu.java1;

/**
 * @author Shan Cheng
 * @date 2020/12/26-18:56
 */
@MyAnnotation(value = "hi")
public class Person extends Creature<String> implements Comparable<String>, MyInterface
{
    private String name;
    int age;
    public int id;

    public Person()
    {
    }

    @MyAnnotation(value = "abc")
    private Person(String name)
    {
        this.name = name;
    }

    Person(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    @MyAnnotation
    private void show(String nation)
    {
        System.out.println("我的国籍是：" + nation);
    }

    public String display(String interests, int age) throws NullPointerException, ClassCastException
    {
        return interests + age;
    }

    @Override
    public int compareTo(String o)
    {
        return 0;
    }

    @Override
    public void info()
    {
        System.out.println("我是一个人");
    }
}