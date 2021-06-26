package org.seckill.exception;

/**
 * 重复秒杀异常（运行时异常）
 *
 * @author Shan Cheng
 * @since 2021/4/18
 */
public class RepeatKillException extends SecKillException
{
    public RepeatKillException(String message)
    {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
