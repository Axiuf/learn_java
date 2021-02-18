package com.bjpowernode.dao.Impl;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.Student;
import com.bjpowernode.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author Shan Cheng
 * @date 2021/2/17-13:28
 */
public class StudentDaoImpl implements StudentDao
{
    @Override
    public List<Student> selectAllStudents()
    {
        SqlSession session = MyBatisUtils.getSqlSession();
        String sqlId = "com.bjpowernode.dao.StudentDao.selectAllStudents";

        List<Student> studentList = session.selectList(sqlId);

//        studentList.forEach(System.out::println);

        session.close();

        return studentList;
    }

    @Override
    public int insertStudent(Student student)
    {
        SqlSession session = MyBatisUtils.getSqlSession();
        String sqlId = "com.bjpowernode.dao.StudentDao.insertStudent";

        int number = session.insert(sqlId, student);

        session.commit();
        session.close();

        return number;
    }
}
