package org.seckill.exception;

/**
 * @author Shan Cheng
 * @since 2021/4/18
 */
public class SecKillException extends RuntimeException
{
    public SecKillException(String message)
    {
        super(message);
    }

    public SecKillException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
