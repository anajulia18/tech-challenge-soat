package com.revenda_veiculos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.revenda_veiculos.model")
public class RevendaVeiculosApplication {
    public static void main(String[] args) {
        SpringApplication.run(RevendaVeiculosApplication.class, args);
    }
}