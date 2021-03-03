package com.atguigu.mpdemo1010.bean;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;


/**
 * @author Shan Cheng
 * @date 2021/2/28
 */

@Data
public class User
{
    // 主键自动生成策略问题
    @TableId(type = IdType.ID_WORKER)
    private Long id;

    private String name;

    private String email;

    private Integer age;

    // Mybatis Plus的自动填充功能
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    // 配置乐观锁的版本号
    @Version
    @TableField(fill = FieldFill.INSERT)
    private Integer version;

    // 配置逻辑删除的属性
    @TableLogic
    private Integer deleted;
}