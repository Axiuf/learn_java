package io.github.axiuf.servicebase.metaobjecthandler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author Shan Cheng
 * @date 2021/3/1
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler
{
    @Override
    public void insertFill(MetaObject metaObject)
    {
        this.setFieldValByName("gmtCreate", new Date(), metaObject);
        this.setFieldValByName("gmtModified", new Date(), metaObject);

    }

    @Override
    public void updateFill(MetaObject metaObject)
    {
        this.setFieldValByName("gmtModified", new Date(), metaObject);
    }
}
