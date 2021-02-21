package com.bjpowernode.domain;

/**
 * @author Shan Cheng
 * @date 2021/2/20
 */
public class MyStudent
{
    private int id;
    private String name;
    private String email;
    private int age;

    public MyStudent()
    {
    }

    public MyStudent(int id, String name, String email, int age)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    @Override
    public String toString()
    {
        return "MyStudent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }

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

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }
}
