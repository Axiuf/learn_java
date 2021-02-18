package com.bjpowernode.dao;

import com.bjpowernode.domain.Student;

import java.util.List;

/**
 * @author Shan Cheng
 * @date 2021/2/17-13:03
 */
public interface StudentDao
{
    public List<Student> selectAllStudents();

    public int insertStudent(Student student);
}
