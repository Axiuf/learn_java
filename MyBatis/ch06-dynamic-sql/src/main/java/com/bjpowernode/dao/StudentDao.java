package com.bjpowernode.dao;

import com.bjpowernode.domain.Student;

import java.util.List;

/**
 * @author Shan Cheng
 * @date 2021/2/17-13:03
 */
public interface StudentDao
{
    public List<Student> testSelectIf1(Student student);

    public List<Student> testSelectIf2(Student student);

    public List<Student> testSelectWhere(Student student);

    public List<Student> testSelectForEach(List<Integer> idList);
}
