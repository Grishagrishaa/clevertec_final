package ru.clevertec.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableCaching
@EnableJpaAuditing
@SpringBootApplication
@EnableTransactionManagement
public class UserServiceApplication{
    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }
}
