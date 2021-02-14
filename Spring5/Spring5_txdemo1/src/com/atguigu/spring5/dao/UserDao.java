package com.atguigu.spring5.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author Shan Cheng
 * @date 2021/2/6-19:59
 */
public interface UserDao
{
    public void addMoney();

    public void reduceMoney();
}
