package io.github.axiuf.eduservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Shan Cheng
 * @date 2021/3/1
 */

@SpringBootApplication
@ComponentScan(basePackages = {"io.github.axiuf"})
public class EduApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(EduApplication.class, args);
    }
}
