package org.seckill.exception;

/**
 * 秒杀过期异常
 *
 * @author Shan Cheng
 * @since 2021/4/18
 */
public class SecKillClosedException extends SecKillException
{
    public SecKillClosedException(String message)
    {
        super(message);
    }

    public SecKillClosedException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
