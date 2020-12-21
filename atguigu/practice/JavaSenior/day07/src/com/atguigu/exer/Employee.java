package com.atguigu.exer;

/**
 * @author Shan Cheng
 * @date 2020/12/21-15:43
 */
public class Employee implements Comparable
{
    private String name;
    private int age;
    private MyDate birthday;

    public Employee()
    {
    }

    public Employee(String name, int age, MyDate birthday)
    {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public Employee(String name, int age, int year, int month, int day)
    {
        this.name = name;
        this.age = age;
        this.birthday = new MyDate(year, month, day);
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

    public MyDate getBirthday()
    {
        return birthday;
    }

    public void setBirthday(MyDate birthday)
    {
        this.birthday = birthday;
    }

    @Override
    public String toString()
    {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }


    @Override
    public int compareTo(Object o) throws RuntimeException
    {
        if (o instanceof Employee)
        {
            Employee other = (Employee) o;
            return this.name.compareTo(other.name);
        }
        else
            throw new RuntimeException("类型错误");
    }
}