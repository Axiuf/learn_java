package org.seckill.dao.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dao.SecKillDao;
import org.seckill.entity.SecKill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author Shan Cheng
 * @since 2021/4/21
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class RedisDaoTest
{
    @Autowired
    private SecKillDao secKillDao;

    @Autowired
    private RedisDao redisDao;

    private long id = 1000;

    @Test
    public void getSecKill()
    {
        SecKill secKill = redisDao.getSecKill(id);
        if (secKill == null)
        {
            secKill = secKillDao.queryById(id);
            if (secKill != null)
            {
                System.out.println(redisDao.putSecKill(secKill));
                System.out.println(redisDao.getSecKill(id));
            }
        }
    }

    @Test
    public void putSecKill()
    {
    }
}