package com.deutsche.retail.main;

import com.deutsche.retail.db.ShopListHolder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Created by saurav on 28/8/16.
 */
@SpringBootApplication(scanBasePackages = "com.deutsche.retail.controllers")
public class ApplicationLauncher {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationLauncher.class, args);
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public ShopListHolder shopListHolder() {
        return new ShopListHolder();
    }
}
