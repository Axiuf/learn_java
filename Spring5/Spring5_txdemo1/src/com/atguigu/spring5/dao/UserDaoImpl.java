package com.atguigu.spring5.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author Shan Cheng
 * @date 2021/2/6-19:59
 */

@Repository
public class UserDaoImpl implements UserDao
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addMoney()
    {
        String sql = "UPDATE t_account SET money=money+? WHERE userName=?";

        int update = jdbcTemplate.update(sql, 100, "lucy");

        System.out.println(update);
    }

    @Override
    public void reduceMoney()
    {
        String sql = "UPDATE t_account SET money=money-? WHERE userName=?";

        int update = jdbcTemplate.update(sql, 100, "mary");

        System.out.println(update);
    }
}
