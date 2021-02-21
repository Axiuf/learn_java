package com.bjpowernode;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.Student;
import com.bjpowernode.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

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
}
