package com.bjpowernode.domain;

/**
 * @author Shan Cheng
 * @date 2021/2/17-13:01
 */
public class Student
{
    private int id;
    private String name;
    private String email;
    private int age;

    public Student()
    {
    }

    public Student(int id, String name, String email, int age)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
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

    @Override
    public String toString()
    {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
