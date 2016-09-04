package com.company.retail.main;

import com.company.retail.service.shop.ShopLocatorService;
import com.company.retail.service.shop.ShopLocatorServiceImpl;
import com.company.retail.db.ShopListHolder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Created by saurav on 28/8/16.
 */
@SpringBootApplication(scanBasePackages = "com.company.retail")
public class ApplicationLauncher {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationLauncher.class, args);
        System.out.println("Application has started successfully with server running at http://localhost:8080/retail/");
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public ShopListHolder shopListHolder() {
        return new ShopListHolder();
    }

    @Bean
    public ShopLocatorService shopLocatorService() {
        return new ShopLocatorServiceImpl();
    }
}
