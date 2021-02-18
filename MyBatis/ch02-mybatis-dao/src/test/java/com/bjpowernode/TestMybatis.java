package com.bjpowernode;

import com.bjpowernode.dao.Impl.StudentDaoImpl;
import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.Student;
import org.junit.Test;

import java.util.List;

/**
 * @author Shan Cheng
 * @date 2021/2/17-13:34
 */
public class TestMybatis
{
    @Test
    public void testSelectAllStudents()
    {
        StudentDao studentDao = new StudentDaoImpl();

        List<Student> studentList = studentDao.selectAllStudents();

        studentList.forEach(System.out::println);
    }

    @Test
    public void testInsertStudent()
    {
        StudentDao studentDao = new StudentDaoImpl();

        Student student = new Student(7, "幺六", "yaoliu@hotmail.com", 27);

        int number = studentDao.insertStudent(student);

        System.out.println(number);
    }
}
