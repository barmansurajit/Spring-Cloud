package com.aran.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SalesTaxService {
    public static void main(String[] args) {
        SpringApplication.run(SalesTaxService.class, args);
    }
}
