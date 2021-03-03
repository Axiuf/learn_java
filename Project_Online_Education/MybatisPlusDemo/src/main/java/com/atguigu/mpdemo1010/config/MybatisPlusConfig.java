package com.atguigu.mpdemo1010.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Shan Cheng
 * @date 2021/2/28
 */

@Configuration
@EnableTransactionManagement
@MapperScan("com.atguigu.mpdemo1010.mapper")
public class MybatisPlusConfig
{
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor()
    {
        return new OptimisticLockerInterceptor();
    }

    @Bean
    public PaginationInterceptor paginationInterceptor()
    {
        return new PaginationInterceptor();
    }

    @Bean
    public ISqlInjector sqlInjector()
    {
        return new LogicSqlInjector();
    }

    @Bean
    @Profile({"dev", "test"})
    public PerformanceInterceptor performanceInterceptor()
    {
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        performanceInterceptor.setMaxTime(100); // ms，超过此处设置的ms则sql不执行
        performanceInterceptor.setFormat(true);
        return performanceInterceptor;
    }
}
