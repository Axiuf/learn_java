package org.seckill.service;

import org.seckill.dto.Exposer;
import org.seckill.dto.SecKillExecution;
import org.seckill.entity.SecKill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SecKillClosedException;
import org.seckill.exception.SecKillException;

import java.util.List;

/**
 * 站在使用者的角度去设计接口
 * 三个方面：方法定义的粒度，参数，返回类型（return 类型/异常）
 *
 * @author Shan Cheng
 * @since 2021/4/18
 */
public interface SecKillService
{
    /**
     * 查询所有的秒杀商品记录
     *
     * @return
     */
    List<SecKill> getSecKillList();

    /**
     * 根据商品id查询单个秒杀商品记录
     *
     * @param secKillId
     * @return
     */
    SecKill getById(long secKillId);

    /**
     * 秒杀开后输出秒杀的链接地址
     * 否则输出系统时间和秒杀时间
     *
     * @param secKillId
     */
    Exposer exportSecKillUrl(long secKillId);

    /**
     * 执行秒杀操作
     *
     * @param secKillId
     * @param userPhone
     * @param md5
     */
    SecKillExecution executeSecKill(long secKillId, long userPhone, String md5)
            throws SecKillException, SecKillClosedException, RepeatKillException;

    /**
     * 执行秒杀操作 利用MySQL存储过程
     * @param secKillId
     * @param userPhone
     * @param md5
     * @return
     */
    SecKillExecution executeSecKillProcedure(long secKillId, long userPhone, String md5);
}
