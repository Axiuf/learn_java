package com.bjpowernode;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.Student;
import com.bjpowernode.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shan Cheng
 * @date 2021/2/17-13:34
 */
public class TestMybatis
{
    @Test
    public void testSelectIf()
    {
        SqlSession session = MyBatisUtils.getSqlSession();
        StudentDao studentDao = session.getMapper(StudentDao.class);

        Student student = new Student();
        student.setAge(26);
        student.setName("王六");
        student.setEmail("zhangsan@qq.com");
        student.setId(2);
        List<Student> student1 = studentDao.testSelectIf2(student);
        System.out.println(student1);
    }
    @Test
    public void testSelectWhere()
    {
        SqlSession session = MyBatisUtils.getSqlSession();
        StudentDao studentDao = session.getMapper(StudentDao.class);

        Student student = new Student(2, "张三", "zhangsan@qq.com", 26);

        List<Student> student1 = studentDao.testSelectWhere(student);
        System.out.println(student1);
    }

    @Test
    public void testSelectForEach()
    {
        SqlSession session = MyBatisUtils.getSqlSession();
        StudentDao studentDao = session.getMapper(StudentDao.class);

        List<Integer> list = new ArrayList<Integer>();

        list.add(1);
        list.add(2);

        List<Student> students = studentDao.testSelectForEach(list);
        System.out.println(students);

    }

}