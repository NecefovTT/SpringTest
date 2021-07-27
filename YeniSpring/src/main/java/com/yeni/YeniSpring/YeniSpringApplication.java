package com.yeni.YeniSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class YeniSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(YeniSpringApplication.class, args);
    }

}
