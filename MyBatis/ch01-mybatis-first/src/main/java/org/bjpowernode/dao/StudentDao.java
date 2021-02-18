package org.bjpowernode.dao;

import org.bjpowernode.domain.Student;

import java.util.List;

/**
 * @author Shan Cheng
 * @date 2021/2/16-16:16
 */
public interface StudentDao
{
    public List<Student> selectAllStudents();
}
