package com.atguigu.spring5.service;

import com.atguigu.spring5.dao.UserDao;
import com.atguigu.spring5.dao.UserDaoImpl;

/**
 * @author Shan Cheng
 * @date 2021/2/2-22:25
 */
public class UserService
{
    private UserDao userDao;

    public void setUserDao(UserDao userDao)
    {
        this.userDao = userDao;
    }

    public void add()
    {
        System.out.println("service add......");

        UserDao userDao = new UserDaoImpl();
        userDao.update();
    }
}
