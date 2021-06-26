package org.seckill.dao.cache;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import org.seckill.entity.SecKill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author Shan Cheng
 * @since 2021/4/21
 */
public class RedisDao
{
    private JedisPool jedisPool;

    private RuntimeSchema<SecKill> schema = RuntimeSchema.createFrom(SecKill.class);

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public RedisDao(String ip, int port)
    {
        jedisPool = new JedisPool(ip, port);
    }

    public SecKill getSecKill(long secKillId)
    {
        try
        {
            try (Jedis jedis = jedisPool.getResource())
            {
                String key = "secKill:" + secKillId;
                byte[] bytes = jedis.get(key.getBytes());
                if (bytes != null)
                {
                    SecKill secKill = schema.newMessage();
                    ProtostuffIOUtil.mergeFrom(bytes, secKill, schema);

                    return secKill;
                }
            }
        }
        catch (Exception e)
        {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    public String putSecKill(SecKill secKill)
    {
        try
        {
            try (Jedis jedis = jedisPool.getResource())
            {
                String key = "secKill:" + secKill.getSecKillId();
                byte[] bytes = ProtostuffIOUtil.toByteArray(secKill, schema,
                        LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));

                int timeout = 60 * 60;
                return jedis.setex(key.getBytes(), timeout, bytes);
            }
        }
        catch (Exception e)
        {
            logger.error(e.getMessage(), e);
        }
        return null;
    }
}
