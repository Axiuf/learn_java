package com.atguigu.spring5.bean;

/**
 * @author Shan Cheng
 * @date 2021/2/3-21:53
 */
public class Dept
{
    private String deptName;

    public void setDeptName(String deptName)
    {
        this.deptName = deptName;
    }

    @Override
    public String toString()
    {
        return "Dept{" +
                "deptName='" + deptName + '\'' +
                '}';
    }
}