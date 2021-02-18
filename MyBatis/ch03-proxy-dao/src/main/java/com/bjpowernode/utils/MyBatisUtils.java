package com.bjpowernode.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Shan Cheng
 * @date 2021/2/16-21:37
 */
public class MyBatisUtils
{
    public static SqlSessionFactory sqlSessionFactory = null;

    static
    {
        String config = "mybatis.xml";

        try
        {
            InputStream in = Resources.getResourceAsStream(config);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static SqlSession getSqlSession()
    {
        SqlSession sqlSession = null;

        if (sqlSessionFactory != null)
        {
            sqlSession = sqlSessionFactory.openSession();
        }

        return sqlSession;
    }
}
