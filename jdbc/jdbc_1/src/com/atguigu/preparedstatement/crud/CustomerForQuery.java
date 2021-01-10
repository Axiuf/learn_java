package com.atguigu.preparedstatement.crud;

import com.atguigu.bean.Customer;
import com.atguigu.util.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.*;

/**
 * @author Shan Cheng
 * @date 2021/1/7-13:37
 */
public class CustomerForQuery
{
    @Test
    public void testQuery()
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try
        {
            // 1. 获取数据库连接
            connection = JDBCUtils.getConnection();

            // 2. 预编译sql语句
            String sql = "SELECT id, name, email, birth FROM customers WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, 5);

            // 3. 执行
            resultSet = preparedStatement.executeQuery();

            // 4. 处理结果集
            if (resultSet.next()) // next()方法判断结果集的下一条是否有数据，返回布尔值并且指针下移
            {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String email = resultSet.getString(3);
                Date birth = resultSet.getDate(4);

                // 方式一：
//                System.out.println("id = " + id + ", name = " + name + ", email = " + email + ", birth = " + birth);

                // 方式二：
//                Object[] data = new Object[]{id, name, email, birth};

                // 方式三：将数据封装为对象
                Customer customer = new Customer(id, name, email, birth);
                System.out.println(customer);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            JDBCUtils.closeResource(connection, preparedStatement, resultSet);
        }
    }


    // 针对Customer表的通用操作
    public Customer queryForCustomer(String sql, Object ...args)
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try
        {
            connection = JDBCUtils.getConnection();

            preparedStatement = connection.prepareStatement(sql);

            for (int i = 0; i < args.length; i++)
            {
                preparedStatement.setObject(i + 1, args[i]);
            }

            resultSet = preparedStatement.executeQuery();

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            if (resultSet.next())
            {
                Customer customer = new Customer();

                // 处理结果集中每一行数据中的每一个列
                for (int i = 0; i < columnCount; i++)
                {
                    // 获取列值
                    Object columnValue = resultSet.getObject(i + 1);

                    // 获取每个列的列名
                    String columnName = metaData.getColumnName(i + 1);

                    // 给customer对象指定的columnName属性，赋值为columnValue，通过反射
                    Field field = Customer.class.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(customer, columnValue);
                }

                return customer;
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            JDBCUtils.closeResource(connection, preparedStatement, resultSet);
        }

        return null;
    }

    @Test
    public void testQueryForCustomers()
    {
        String sql = "SELECT id, name, email, birth FROM customers WHERE id = ?";
        Customer customer = queryForCustomer(sql, 13);

        System.out.println(customer);
    }
}