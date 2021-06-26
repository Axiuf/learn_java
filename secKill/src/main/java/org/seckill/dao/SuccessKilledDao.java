package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.SuccessKilled;

/**
 * @author Shan Cheng
 * @since 2021/4/16
 */
public interface SuccessKilledDao
{
    /**
     * 插入购买明细，可过滤重复
     * @param secKillId
     * @param userPhone
     * @return 插入的行数
     */
    int insertSuccessKilled(@Param("secKillId") long secKillId, @Param("userPhone") long userPhone);

    /**
     * 根据id查询SuccessKilled
     * @param secKillId
     * @return
     */
    SuccessKilled queryByIdWithSecKill(@Param("secKillId") long secKillId, @Param("userPhone") long userPhone);
}
