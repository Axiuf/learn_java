package com.atguigu.spring5.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author Shan Cheng
 * @date 2021/2/10-11:58
 */


@Configuration
@ComponentScan(basePackages = "com.atguigu")
@EnableTransactionManagement
public class TxConfig
{
    @Bean
    public DruidDataSource getDruidDataSource()
    {
        DruidDataSource dataSource = new DruidDataSource();

        dataSource.setUrl("jdbc:mysql://localhost:3306/user_db?useUnicode=true&characterEncoding=utf8");
        dataSource.setUsername("root");
        dataSource.setPassword("password");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");

        return dataSource;
    }

    @Bean
    public JdbcTemplate getJdbcTemplate(DataSource dataSource)
    {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();

        jdbcTemplate.setDataSource(dataSource);

        return jdbcTemplate;
    }

    @Bean
    public DataSourceTransactionManager getDataSourceTransactionManager(DataSource dataSource)
    {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();

        dataSourceTransactionManager.setDataSource(dataSource);

        return dataSourceTransactionManager;
    }
}
