package com.umg.backendbanco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.umg.backendbanco", "com.umg.banco"})
public class BackendFase1Application {
    public static void main(String[] args) {
        SpringApplication.run(BackendFase1Application.class, args);
    }
}