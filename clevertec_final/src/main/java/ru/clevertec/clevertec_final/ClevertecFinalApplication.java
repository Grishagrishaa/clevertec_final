package ru.clevertec.clevertec_final;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableCaching
@EnableJpaAuditing
@SpringBootApplication
@EnableMethodSecurity
@ApiResponse
@EnableTransactionManagement(order = 0)
@SecurityScheme(type = SecuritySchemeType.APIKEY, name = "api_key", in = SecuritySchemeIn.DEFAULT)
public class ClevertecFinalApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClevertecFinalApplication.class, args);
    }
}
