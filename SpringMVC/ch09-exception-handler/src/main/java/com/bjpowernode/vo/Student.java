package com.bjpowernode.vo;

/**
 * @author Shan Cheng
 * @date 2021/2/23
 */
public class Student
{
    private String name;
    private Integer age;

    public Student()
    {
        System.out.println("调用Student的空参数构造器");
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
        System.out.println("name的set方法");
    }

    public Integer getAge()
    {
        return age;
    }

    public void setAge(Integer age)
    {
        this.age = age;
        System.out.println("age的set方法");
    }

    @Override
    public String toString()
    {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
