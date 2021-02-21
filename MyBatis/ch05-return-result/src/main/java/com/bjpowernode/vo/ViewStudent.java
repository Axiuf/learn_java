package com.bjpowernode.vo;

/**
 * @author Shan Cheng
 * @date 2021/2/19
 */
public class ViewStudent
{
    private int id;
    private String name;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "ViewStudent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
