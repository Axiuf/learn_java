package org.github.axiuf.service.impl;

import org.github.axiuf.dao.StudentDao;
import org.github.axiuf.domain.Student;
import org.github.axiuf.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Shan Cheng
 * @date 2021/2/24
 */

@Service
public class StudentServiceImpl implements StudentService
{
    private StudentDao studentDao;

    public StudentDao getStudentDao()
    {
        return studentDao;
    }

    @Autowired
    public void setStudentDao(StudentDao studentDao)
    {
        this.studentDao = studentDao;
    }

    @Override
    public int addStudent(Student student)
    {
        int nums = studentDao.insertStudent(student);
        return nums;
    }

    @Override
    public List<Student> showStudents()
    {
        return studentDao.selectStudents();
    }
}
