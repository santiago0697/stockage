package com.stockage.stockage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class StockageApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockageApplication.class, args);
    }
}
