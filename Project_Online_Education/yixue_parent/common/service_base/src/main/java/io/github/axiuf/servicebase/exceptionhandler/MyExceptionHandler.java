package io.github.axiuf.servicebase.exceptionhandler;

/**
 * @author Shan Cheng
 * @date 2021/3/1
 */

import io.github.axiuf.commonutils.ExceptionUtil;
import io.github.axiuf.commonutils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class MyExceptionHandler
{
    @ExceptionHandler(Exception.class)
    @ResponseBody // 为了能够返回数据
    public R exceptionHandler(Exception e)
    {
        e.printStackTrace();

        return R.error().message("执行了全局异常处理...");
    }

    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody // 为了能够返回数据
    public R exceptionHandler(ArithmeticException e)
    {
        e.printStackTrace();

        return R.error().message("执行了ArithmeticException异常处理...");
    }

    @ExceptionHandler(YixueException.class)
    @ResponseBody // 为了能够返回数据
    public R exceptionHandler(YixueException e)
    {
        log.error(ExceptionUtil.getMessage(e));

        e.printStackTrace();

        return R.error().code(e.getCode()).message(e.getMsg());
    }
}
