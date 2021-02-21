package com.bjpowernode.dao;

import com.bjpowernode.domain.Student;
import org.apache.ibatis.annotations.Param;

/**
 * @author Shan Cheng
 * @date 2021/2/17-13:03
 */
public interface StudentDao
{
    public Student selectStudentById(Integer id);

    public Student selectStudentMultiParam(@Param("myId") Integer id, @Param("myAge") Integer age);
}
