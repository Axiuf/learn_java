package com.atguigu.connection;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Shan Cheng
 * @date 2021/1/6-13:27
 */
public class ConnectionTest
{
    // 方式一：
    @Test
    public void testConnection1() throws SQLException
    {
        Driver driver = new com.mysql.jdbc.Driver();

        String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8";
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "Axiuf869");

        Connection connect = driver.connect(url, info);

        System.out.println(connect);
    }

    // 方式二：对方式一的迭代，在如下的程序中不出现第三方的api，使得程序具有更好的可移植性
    @Test
    public void testConnection2() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException
    {
        // 1. 获取Driver实现类的对象，使用反射
        Class aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();

        // 2. 提供要连接的数据库
        String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8";

        // 3. 提供要连接的用户名和密码
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "Axiuf869");

        // 4. 获取连接
        Connection connect = driver.connect(url, info);
        System.out.println(connect);
    }

    // 方式三：使用DriverManager替换Driver
    @Test
    public void testConnection3() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException
    {
        // 1. 获取Driver实现类的对象，使用反射
        Class aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();

        // 2. 提供另外的三个基本信息
        String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8";
        String user = "root";
        String password = "Axiuf869";

        // 注册驱动
        DriverManager.registerDriver(driver);

        // 获取连接
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }

    // 方式四：可以只是加载驱动，不用显式的注册驱动
    @Test
    public void testConnection4() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException
    {
        // 1. 提供另外的三个基本信息
        String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8";
        String user = "root";
        String password = "Axiuf869";

        // 2. 获取Driver实现类的对象，使用反射
        Class.forName("com.mysql.jdbc.Driver");

        // 相比较于方式三，可以省略如下的操作，因为在Driver类的加载中，其静态代码块帮我们做了
//        Driver driver = (Driver) aClass.newInstance();
//        // 注册驱动
//        DriverManager.registerDriver(driver);

        // 3. 获取连接
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }

    // 方式五：最终版本，将数据连接需要的4个基本信息声明在配置文件中，通过读取配置文件，获取连接
    @Test
    public void testConnection5() throws IOException, ClassNotFoundException, SQLException
    {
        // 1. 读取配置文件中的4个基本信息
        InputStream inputStream = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");

        Properties properties = new Properties();

        properties.load(inputStream);

        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driverClass = properties.getProperty("driverClass");

        // 2. 加载驱动
        Class.forName(driverClass);

        // 3. 获取连接
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }
}
