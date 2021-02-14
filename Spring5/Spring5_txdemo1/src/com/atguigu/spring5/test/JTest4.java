package com.atguigu.spring5.test;

import com.atguigu.spring5.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Shan Cheng
 * @date 2021/2/10-23:33
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath: bean2.xml")
public class JTest4
{
    @Autowired
    private UserService userService;

    @Test
    public void test()
    {
        userService.accountMoney();
    }
}
