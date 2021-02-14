package com.atguigu.spring5.collectionType;

/**
 * @author Shan Cheng
 * @date 2021/2/3-23:54
 */
public class Course
{
    private String name;

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "Course{" +
                "name='" + name + '\'' +
                '}';
    }
}
