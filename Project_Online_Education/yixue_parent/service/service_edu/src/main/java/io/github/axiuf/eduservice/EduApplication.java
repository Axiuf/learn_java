package io.github.axiuf.eduservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Shan Cheng
 * @date 2021/3/1
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@ComponentScan(basePackages = {"io.github.axiuf"})
public class EduApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(EduApplication.class, args);
    }
}
