package com.atguigu.preparedstatement.crud;

import com.atguigu.connection.ConnectionTest;
import com.atguigu.util.JDBCUtils;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.logging.SimpleFormatter;

/**
 * 使用PreparedStatement来替换Statement，实现对数据表的增删改查操作
 *
 * @author Shan Cheng
 * @date 2021/1/7-10:19
 */
public class PreparedStatementUpdateTest
{
    // 向customers表中添加一条记录
    @Test
    public void testInsert()
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try
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
            connection = DriverManager.getConnection(url, user, password);

            // 4. 预编译sql语句，返回PreparedStatement的实例
            String sql = "INSERT INTO customers(name, email, birth) VALUES(?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);

            // 5. 填充占位符
            preparedStatement.setString(1, "哪吒");
            preparedStatement.setString(2, "nezha@gmail.com");

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = simpleDateFormat.parse("1000-01-01");
            preparedStatement.setDate(3, new Date(date.getTime()));

            // 6. 执行操作
            preparedStatement.execute();
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            // 7. 资源关闭
            try
            {
                if (preparedStatement != null)
                    preparedStatement.close();
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
    }


    // 修改customers表中的一条记录
    @Test
    public void testUpdate()
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try
        {
            // 1. 获取数据库的连接
            connection = JDBCUtils.getConnection();

            // 2. 预编译sql语句，返回PreparedStatement的实例
            String sql = "UPDATE customers SET name = ? WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);

            // 3. 填充占位符
            preparedStatement.setObject(1, "猎人A");
            preparedStatement.setObject(2, 18);

            // 4. 执行
            preparedStatement.execute();
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            // 5. 资源的关闭
            JDBCUtils.closeResource(connection, preparedStatement);
        }
    }

    // 通用的增删改的操作
    public void update(String sql, Object ...args) // sql中占位符的个数和位置应该与可变形参一致
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try
        {
            // 1. 获取数据库连接
            connection = JDBCUtils.getConnection();

            // 2. 预编译sql语句，返回PreparedStatement的实例
            preparedStatement = connection.prepareStatement(sql);

            // 3. 填充占位符
            for (int i = 0; i < args.length; i++)
            {
                preparedStatement.setObject(i + 1, args[i]);
            }

            // 4. 执行
            preparedStatement.execute();
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            // 5. 关闭资源
            JDBCUtils.closeResource(connection, preparedStatement);
        }
    }

    @Test
    public void testCommonUpdate()
    {
//        String sql = "DELETE FROM customers WHERE id = ?";
//        update(sql, 3);

        String sql = "UPDATE `order` SET order_name = ? WHERE order_id = ?";
        update(sql, "DD", 2);
    }
}