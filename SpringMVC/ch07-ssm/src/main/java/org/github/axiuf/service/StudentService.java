package org.github.axiuf.service;

import org.github.axiuf.domain.Student;

import java.util.List;

/**
 * @author Shan Cheng
 * @date 2021/2/24
 */
public interface StudentService
{
    public int addStudent(Student student);

    public List<Student> showStudents();
}
