package org.seckill.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.Exposer;
import org.seckill.dto.SecKillExecution;
import org.seckill.entity.SecKill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SecKillClosedException;
import org.seckill.service.SecKillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author Shan Cheng
 * @since 2021/4/18
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class SecKillServiceImplTest
{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SecKillService secKillService;

    @Test
    public void getSecKillList()
    {
        List<SecKill> secKillList = secKillService.getSecKillList();
        logger.info("list={}", secKillList);
    }

    @Test
    public void getById()
    {
        long id = 1000;
        SecKill secKill = secKillService.getById(id);
        logger.info("secKill={}", secKill);
    }

    // 测试代码完整逻辑，测试是否可重复执行
    @Test
    public void testSecKillLogic()
    {
        long id = 1001;
        Exposer exposer = secKillService.exportSecKillUrl(id);
        if (exposer.isExposed())
        {
            logger.info("exposer={}", exposer);

            long phone = 15921252131L;
            String md5 = exposer.getMd5();

            try
            {
                SecKillExecution execution = secKillService.executeSecKill(id, phone, md5);
                logger.info("execution={}", execution);
            }
            catch (RepeatKillException | SecKillClosedException e)
            {
                logger.error(e.getMessage());
            }
        }
        else
        {
            // 秒杀未开启
            logger.warn("exposer:{}", exposer);
        }
    }

    @Test
    public void executeSecKillProcedure()
    {
        long secKillId = 1003L;
        long phone = 15921252142L;
        Exposer exposer = secKillService.exportSecKillUrl(secKillId);
        if (exposer.isExposed())
        {
            String md5 = exposer.getMd5();
            SecKillExecution execution = secKillService.executeSecKillProcedure(secKillId, phone, md5);
            logger.info(execution.getStateInfo());
        }
    }
}
