package com.atguigu.exer;

/**
 * @author Shan Cheng
 * @date 2020/12/21-15:44
 */
public class MyDate implements Comparable
{
    private int year;
    private int month;
    private int day;

    public MyDate()
    {
    }

    public MyDate(int year, int month, int day)
    {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear()
    {
        return year;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    public int getMonth()
    {
        return month;
    }

    public void setMonth(int month)
    {
        this.month = month;
    }

    public int getDay()
    {
        return day;
    }

    public void setDay(int day)
    {
        this.day = day;
    }

    @Override
    public String toString()
    {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }


    @Override
    public int compareTo(Object o)
    {
        if (o instanceof MyDate)
        {
            MyDate other = (MyDate) o;
            if (this.year < other.getYear())
                return -1;
            else if (this.year > other.getYear())
                return 1;
            else if (this.year == other.getYear())
            {
                if (this.month < other.getMonth())
                    return -1;
                else if (this.month > other.getMonth())
                    return 1;
                else if (this.month == other.getMonth())
                {
                    if (this.day < other.getDay())
                        return -1;
                    else if (this.day > other.getDay())
                        return 1;
                    else
                        return 0;
                }
            }
        }

        throw new RuntimeException("数据类型错误");
    }
}
