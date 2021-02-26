package org.github.axiuf.dao;

import org.github.axiuf.domain.Student;

import java.util.List;

/**
 * @author Shan Cheng
 * @date 2021/2/24
 */
public interface StudentDao
{
    public int insertStudent(Student student);

    public List<Student> selectStudents();
}
