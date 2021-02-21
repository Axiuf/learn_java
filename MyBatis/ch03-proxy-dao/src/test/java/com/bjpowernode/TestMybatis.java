package com.bjpowernode;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.Student;
import com.bjpowernode.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
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
        SqlSession session = MyBatisUtils.getSqlSession();
        StudentDao studentDao = session.getMapper(StudentDao.class);

        System.out.println(studentDao.getClass().getName());
        List<Student> studentList = studentDao.selectAllStudents();
        studentList.forEach(System.out::println);

    }

    @Test
    public void testInsertStudent()
    {
        SqlSession session = MyBatisUtils.getSqlSession();
        StudentDao studentDao = session.getMapper(StudentDao.class);

        System.out.println(studentDao.insertStudent(new Student(3, "王五", "wangwu@qq.com", 26)));
        session.commit();
    }
}
