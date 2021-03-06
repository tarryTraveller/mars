package com.mars;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan(value = "com.mars.mapper")
@EnableEurekaClient
@EnableDiscoveryClient
public class ProductApp3{
    public static void main(String[] args) {
        SpringApplication.run(ProductApp3.class,args);
    }
}
