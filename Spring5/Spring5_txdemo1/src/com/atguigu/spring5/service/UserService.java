package com.atguigu.spring5.service;

import com.atguigu.spring5.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Shan Cheng
 * @date 2021/2/6-19:58
 */

@Service
@Transactional
public class UserService
{
    @Autowired
    private UserDao userDao;

    public void accountMoney()
    {
        userDao.addMoney();

//        int i = 10 / 0;

        userDao.reduceMoney();
    }
}
