package io.github.axiuf.educenter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Shan Cheng
 * @since 2021/3/15
 */
@ComponentScan({"io.github.axiuf"})
@SpringBootApplication//取消数据源自动配置
@MapperScan("io.github.axiuf.educenter.mapper")
@EnableDiscoveryClient
public class ServiceUcApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceUcApplication.class, args);
    }
}
