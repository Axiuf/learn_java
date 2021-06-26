package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SecKill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * 配置spring和junit整合，junit启动时加载springIOC容器
 * spring-test, junit
 *
 * @author Shan Cheng
 * @since 2021/4/17
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SecKillDaoTest
{
    @Resource
    private SecKillDao secKillDao;

    @Test
    public void reduceNumber()
    {
        Date killTime = new Date();
        System.out.println(secKillDao.reduceNumber(1000L, killTime));
    }

    @Test
    public void queryById()
    {
        long id = 1000;
        SecKill secKill = secKillDao.queryById(id);
        System.out.println(secKill.getName());
        System.out.println(secKill);
    }

    @Test
    public void queryAll()
    {
        List<SecKill> secKills = secKillDao.queryAll(0, 100);
        for (SecKill sc : secKills)
        {
            System.out.println(sc);
        }
    }
}