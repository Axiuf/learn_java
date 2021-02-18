package org.bjpowernode;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.bjpowernode.domain.Student;
import org.bjpowernode.utils.MyBatisUtils;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Statement;
import java.util.List;

/**
 * @author Shan Cheng
 * @date 2021/2/16-20:10
 */
public class MyBatisTest
{
    @Test
    public void testStart() throws IOException
    {
        String config = "mybatis.xml";

        InputStream in = Resources.getResourceAsStream(config);

        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        SqlSessionFactory factory = sqlSessionFactoryBuilder.build(in);

        SqlSession session = factory.openSession();

        List<Student> studentList = session.selectList("org.bjpowernode.dao.StudentDao.selectAllStudents");

        studentList.forEach(System.out::println);

        session.close();
    }

    @Test
    public void testUtils()
    {
        SqlSession session = MyBatisUtils.getSqlSession();

        String sqlId = "org.bjpowernode.dao.StudentDao.selectAllStudents";

        List<Student> studentList = session.selectList(sqlId);

        studentList.forEach(System.out::println);

        session.close();
    }
}
