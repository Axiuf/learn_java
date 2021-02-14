package com.atguigu.spring5.bean;

/**
 * @author Shan Cheng
 * @date 2021/2/3-21:54
 */
public class Emp
{
    private String name;
    private String gender;

    // 用一个对象属性表示从属关系
    private Dept dept;

    public void setName(String name)
    {
        this.name = name;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public void setDept(Dept dept)
    {
        this.dept = dept;
    }

    public void add()
    {
        System.out.println(name + "::" + gender + "::" + dept.toString());
    }
}