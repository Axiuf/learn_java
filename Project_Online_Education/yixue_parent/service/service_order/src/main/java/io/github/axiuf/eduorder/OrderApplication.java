package io.github.axiuf.eduorder;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Shan Cheng
 * @since 2021/3/20
 */

@SpringBootApplication
@ComponentScan(basePackages = {"io.github.axiuf"})
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("io.github.axiuf.eduorder.mapper")
public class OrderApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(OrderApplication.class, args);
    }
}
