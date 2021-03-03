package com.atguigu.mpdemo1010.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;


/**
 * @author Shan Cheng
 * @date 2021/2/28
 */

@Component
public class MyMetaObjectHandler implements MetaObjectHandler
{
    @Override
    public void insertFill(MetaObject metaObject)
    {
        this.setFieldValByName("createTime", new Date(), metaObject);
        this.setFieldValByName("updateTime", new Date(), metaObject);
        this.setFieldValByName("version", 1, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject)
    {
        this.setFieldValByName("updateTime", new Date(), metaObject);
    }
}
