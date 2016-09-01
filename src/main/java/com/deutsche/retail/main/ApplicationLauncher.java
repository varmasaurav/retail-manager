package com.deutsche.retail.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by saurav on 28/8/16.
 */
@SpringBootApplication(scanBasePackages = "com.deutsche.retail.controllers")
public class ApplicationLauncher {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationLauncher.class, args);
    }
}
