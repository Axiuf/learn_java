package com.atguigu.spring5.autowire;

/**
 * @author Shan Cheng
 * @date 2021/2/4-14:37
 */
public class Emp
{
    private Dept dept;

    public void setDept(Dept dept)
    {
        this.dept = dept;
    }

    @Override
    public String toString()
    {
        return "Emp{" +
                "dept=" + dept +
                '}';
    }

    public void test()
    {
        System.out.println(dept);
    }
}
