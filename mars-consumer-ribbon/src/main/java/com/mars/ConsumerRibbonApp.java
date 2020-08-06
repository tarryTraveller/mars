package com.mars;

import com.mars.config.RibbonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@RibbonClient(name = "MARS-PRODUCT",configuration = RibbonConfig.class)
public class ConsumerRibbonApp {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerRibbonApp.class,args);
    }
}