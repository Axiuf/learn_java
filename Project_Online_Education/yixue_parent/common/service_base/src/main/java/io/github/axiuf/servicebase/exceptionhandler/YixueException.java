package io.github.axiuf.servicebase.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author Shan Cheng
 * @date 2021/3/2
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class YixueException extends RuntimeException
{
    // 状态码
    private Integer code;

    // 异常信息
    private String msg;

    @Override
    public String toString()
    {
        return "YixueException{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
