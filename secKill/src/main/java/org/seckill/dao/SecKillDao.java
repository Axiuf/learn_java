package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.SecKill;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Shan Cheng
 * @since 2021/4/16
 */
public interface SecKillDao
{
    /**
     * 减库存
     * @param secKillId
     * @param killTime
     * @return 如果影响行数大于0，表示更新的记录行数
     */
    int reduceNumber(@Param("secKillId") long secKillId, @Param("killTime") Date killTime);

    /**
     * 根据id查询秒杀对象
     * @param secKillId
     * @return
     */
    SecKill queryById(long secKillId);

    /**
     * 根据id偏移量以及数量限制查询
     * @param offSet
     * @param limit
     * @return
     */
    List<SecKill> queryAll(@Param("offSet") int offSet, @Param("limit") int limit);

    /**
     * 使用存储过程执行秒杀
     * @param paraMap
     */
    void killByProcedure(Map<String, Object> paraMap);

}
