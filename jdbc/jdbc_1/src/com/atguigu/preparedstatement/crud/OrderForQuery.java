package com.atguigu.preparedstatement.crud;

import com.atguigu.util.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;

/**
 * @author Shan Cheng
 * @date 2021/1/7-15:11
 */
public class OrderForQuery
{
    @Test
    public void testQuery() throws Exception
    {
        Connection connection = JDBCUtils.getConnection();
    }
}
