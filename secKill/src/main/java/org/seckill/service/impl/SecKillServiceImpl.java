package org.seckill.service.impl;

import org.apache.commons.collections.MapUtils;
import org.seckill.dao.SecKillDao;
import org.seckill.dao.SuccessKilledDao;
import org.seckill.dao.cache.RedisDao;
import org.seckill.dto.Exposer;
import org.seckill.dto.SecKillExecution;
import org.seckill.entity.SecKill;
import org.seckill.entity.SuccessKilled;
import org.seckill.enums.SecKillStatEnum;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SecKillClosedException;
import org.seckill.exception.SecKillException;
import org.seckill.service.SecKillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.*;

/**
 * @author Shan Cheng
 * @since 2021/4/18
 */

// 声明为组件的注解：@Component / @Service / @Controller
@Service
public class SecKillServiceImpl implements SecKillService
{
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // 依赖注入的注解：@Autowired / @Resource
    @Autowired
    private SecKillDao secKillDao;

    @Autowired
    private SuccessKilledDao successKilledDao;

    @Autowired
    private RedisDao redisDao;

    // 随机字符串，拼接到id上，混淆MD5加密后的结果
    private final String salt = "Th#$is#@Is#$@ASal$#tStri&$ng";

    @Override
    public List<SecKill> getSecKillList()
    {
         return secKillDao.queryAll(0, 4);
    }

    @Override
    public SecKill getById(long secKillId)
    {
        return secKillDao.queryById(secKillId);
    }

    private String getMD5(long secKillId)
    {
        String base = secKillId + "/" + salt;

        return DigestUtils.md5DigestAsHex(base.getBytes());
    }

    @Override
    public Exposer exportSecKillUrl(long secKillId)
    {
        // 优化点：缓存优化
        SecKill secKill = redisDao.getSecKill(secKillId);
        if (secKill == null)
        {
            secKill = secKillDao.queryById(secKillId);

            if (secKill == null) return new Exposer(false, secKillId);
            else redisDao.putSecKill(secKill);
        }

        Date startTime = secKill.getStartTime();
        Date endTime = secKill.getEndTime();
        // 获取系统当前时间
        Date nowTime = new Date();

        // 如果不再秒杀的时间范围之内，则返回开始时间和结束时间
        if (nowTime.getTime() < startTime.getTime() || nowTime.getTime() > endTime.getTime())
            return new Exposer(false, secKillId, nowTime.getTime(), startTime.getTime(), endTime.getTime());

        String md5 = getMD5(secKillId);
        return new Exposer(true, md5, secKillId);
    }

    /**
     * 使用注解控制事务方法的优点
     * 1.开发团队达成一致的约定，明确标注事务方法的编程风格
     * 2.保证事务方法的执行时间尽可能短，不要穿插其他的网络操作比如RPC/HTTP等请求，或者剥离到事务方法外部
     * 3.不是所有的方法都需要事务，如果只有一条修改或者只读的操作不需要事务控制
     */
    @Override
    @Transactional
    public SecKillExecution executeSecKill(long secKillId, long userPhone, String md5)
            throws SecKillException, SecKillClosedException, RepeatKillException
    {
        if (md5 == null || !md5.equals(getMD5(secKillId))) throw new SecKillException("secKill data rewrite");

        // 执行秒杀逻辑：减库存，记录购买行为
        Date nowTime = new Date();

        try
        {
            // 先尝试去记录购买行为
            int insertCount = successKilledDao.insertSuccessKilled(secKillId, userPhone);
            // 没有插入成功，说明重复秒杀，直接抛异常
            if (insertCount <= 0) throw new SecKillClosedException("secKill repeated");
            else
            {
                // 再尝试减库存
                int updateCount = secKillDao.reduceNumber(secKillId, nowTime);
                // 没有更新到记录，秒杀结束
                if (updateCount <= 0) throw new RepeatKillException("secKill closed");
                else
                {
                    // 秒杀成功
                    SuccessKilled successKilled = successKilledDao.queryByIdWithSecKill(secKillId, userPhone);
                    return new SecKillExecution(secKillId, SecKillStatEnum.SUCCESS, successKilled);
                }
            }
        }
        catch (SecKillClosedException | RepeatKillException e1)
        {
            throw e1;
        }
        catch (Exception e)
        {
            logger.error(e.getMessage(), e);
            throw new SecKillException("secKill inner error: " + e.getMessage());
        }
    }

    @Override
    public SecKillExecution executeSecKillProcedure(long secKillId, long userPhone, String md5)
    {
        if (md5 == null || !md5.equals(getMD5(secKillId)))
            return new SecKillExecution(secKillId, SecKillStatEnum.DATA_REWRITE);

        // 执行秒杀逻辑：减库存，记录购买行为
        Date nowTime = new Date();
        HashMap<String, Object> map = new HashMap<>();
        map.put("secKillId", secKillId);
        map.put("phone", userPhone);
        map.put("killTime", nowTime);
        map.put("result", null);

        try
        {
            secKillDao.killByProcedure(map);
            Integer result = MapUtils.getInteger(map, "result", -2);
            if (result == 1)
            {
                SuccessKilled sk = successKilledDao.queryByIdWithSecKill(secKillId, userPhone);
                return new SecKillExecution(secKillId, SecKillStatEnum.SUCCESS, sk);
            }
            else
            {
                return new SecKillExecution(secKillId, Objects.requireNonNull(SecKillStatEnum.stateOf(result)));
            }
        }
        catch (Exception e)
        {
            logger.error(e.getMessage(), e);
            return new SecKillExecution(secKillId, SecKillStatEnum.INNER_ERROR);
        }
    }
}
