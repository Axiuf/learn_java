package com.atguigu.spring5.collectionType;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Shan Cheng
 * @date 2021/2/3-22:43
 */
public class Stu
{
    // 设定属性，并且添加对应的set方法
    private String[] array;

    private List<String> list;

    private Map<String, String> map;

    private Set<String> set;

    private List<Course> courseList;

    private String[] bookList;

    public void setArray(String[] array)
    {
        this.array = array;
    }

    public void setList(List<String> list)
    {
        this.list = list;
    }

    public void setMap(Map<String, String> map)
    {
        this.map = map;
    }

    public void setSet(Set<String> set)
    {
        this.set = set;
    }

    public void setCourseList(List<Course> courseList)
    {
        this.courseList = courseList;
    }

    public void setBookList(String[] bookList)
    {
        this.bookList = bookList;
    }

    public void test()
    {
        System.out.println(Arrays.toString(array));
        System.out.println(list);
        System.out.println(map);
        System.out.println(set);
        System.out.println(courseList);
        System.out.println(Arrays.toString(bookList));
    }
}
