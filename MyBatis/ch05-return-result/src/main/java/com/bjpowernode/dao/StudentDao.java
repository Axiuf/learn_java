package com.bjpowernode.dao;

import com.bjpowernode.domain.MyStudent;
import com.bjpowernode.domain.Student;
import com.bjpowernode.vo.ViewStudent;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author Shan Cheng
 * @date 2021/2/17-13:03
 */
public interface StudentDao
{
    public Student selectStudentById(@Param("myId") Integer id);

    public Student selectStudentMultiParam(@Param("myId") Integer id, @Param("myAge") Integer age);

    public ViewStudent selectStudentReturnViewStudent(@Param("myId") Integer id);

    public List<Map> selectMapById(@Param("myId") Integer id);

    public MyStudent selectResultMap(@Param("myId") Integer id);

    public List<Student> selectLike1(@Param("myName") String name);

    public List<Student> selectLike2(@Param("myName") String name);
}
