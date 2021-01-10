package com.atguigu.util;

import com.atguigu.connection.ConnectionTest;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author Shan Cheng
 * @date 2021/1/7-10:55
 */
public class JDBCUtils
{
    // 根据配置文件获取数据库连接
    public static Connection getConnection() throws Exception
    {
        // 1. 读取配置文件中的4个基本信息
        InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");

        Properties properties = new Properties();

        properties.load(inputStream);

        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driverClass = properties.getProperty("driverClass");

        // 2. 加载驱动
        Class.forName(driverClass);

        // 3. 获取连接
        return DriverManager.getConnection(url, user, password);
    }

    // 资源的关闭，使用于不包括结果集的增删改的查询语句
    public static void closeResource(Connection connection, Statement statement)
    {
        try
        {
            if (statement != null)
                statement.close();
        } catch (SQLException throwable)
        {
            throwable.printStackTrace();
        }
        try
        {
            if (connection != null)
                connection.close();
        } catch (SQLException throwable)
        {
            throwable.printStackTrace();
        }
    }

    // 资源的关闭，适用于包含结果集（返回值）的查询语句
    public static void closeResource(Connection connection, Statement statement, ResultSet resultSet)
    {
        try
        {
            if (statement != null)
                statement.close();
        } catch (SQLException throwable)
        {
            throwable.printStackTrace();
        }
        try
        {
            if (connection != null)
                connection.close();
        } catch (SQLException throwable)
        {
            throwable.printStackTrace();
        }

        try
        {
            if (resultSet != null)
                resultSet.close();
        } catch (SQLException throwable)
        {
            throwable.printStackTrace();
        }
    }
}