package com.bjpowernode;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.MyStudent;
import com.bjpowernode.domain.Student;
import com.bjpowernode.utils.MyBatisUtils;
import com.bjpowernode.vo.ViewStudent;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * @author Shan Cheng
 * @date 2021/2/17-13:34
 */
public class TestMybatis
{
    @Test
    public void testSelectStudentById()
    {
        SqlSession session = MyBatisUtils.getSqlSession();
        StudentDao studentDao = session.getMapper(StudentDao.class);

        Student student = studentDao.selectStudentById(2);
        System.out.println(student);
    }

    @Test
    public void testSelectStudentMultiParam()
    {
        SqlSession session = MyBatisUtils.getSqlSession();
        StudentDao studentDao = session.getMapper(StudentDao.class);

        Student student = studentDao.selectStudentMultiParam(1, 25);
        System.out.println(student);
    }

    @Test
    public void testSelectStudentReturnViewStudent()
    {
        SqlSession session = MyBatisUtils.getSqlSession();
        StudentDao studentDao = session.getMapper(StudentDao.class);

        ViewStudent student = studentDao.selectStudentReturnViewStudent(3);
        System.out.println(student);
    }

    @Test
    public void testSelectMapById()
    {
        SqlSession session = MyBatisUtils.getSqlSession();
        StudentDao studentDao = session.getMapper(StudentDao.class);

        List<Map> maps = studentDao.selectMapById(2);
        System.out.println(maps);
    }

    @Test
    public void testSelectResultMap()
    {
        SqlSession session = MyBatisUtils.getSqlSession();
        StudentDao studentDao = session.getMapper(StudentDao.class);

        MyStudent student = studentDao.selectResultMap(3);
        System.out.println(student);
    }

    @Test
    public void testSelectLike1()
    {
        SqlSession session = MyBatisUtils.getSqlSession();
        StudentDao studentDao = session.getMapper(StudentDao.class);

        List<Student> student = studentDao.selectLike1("%王%");
        System.out.println(student);
    }

    @Test
    public void testSelectLike2()
    {
        SqlSession session = MyBatisUtils.getSqlSession();
        StudentDao studentDao = session.getMapper(StudentDao.class);

        List<Student> student = studentDao.selectLike2("李");
        System.out.println(student);
    }
}