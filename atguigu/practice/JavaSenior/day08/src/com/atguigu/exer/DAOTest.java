package com.atguigu.exer;

import org.junit.Test;

/**
 * @author Shan Cheng
 * @date 2020/12/22-16:30
 */
public class DAOTest
{
    @Test
    public void test()
    {
        DAO<User> dao = new DAO<>();
        User u1 = new User("Cheng", 35);
        dao.save(u1.getName(), u1);


    }
}
