package io.github.axiuf.educms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Shan Cheng
 * @since 2021/3/12
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan({"io.github.axiuf"}) //指定扫描位置
@MapperScan("io.github.axiuf.educms.mapper")
public class CmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(CmsApplication.class, args);
    }
}