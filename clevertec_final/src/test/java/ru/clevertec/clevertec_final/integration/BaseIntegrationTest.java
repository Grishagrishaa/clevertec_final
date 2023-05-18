package ru.clevertec.clevertec_final.integration;

import org.junit.jupiter.api.BeforeAll;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import ru.clevertec.clevertec_final.integration.annotation.IT;


import java.util.UUID;

@IT
public abstract class BaseIntegrationTest {

    public static final UUID NEWS_UUID = UUID.fromString("e6dd4609-89e6-4fc6-b4b3-bda2f3a90607");
    public static final UUID COMMENT_UUID = UUID.fromString("e7dd4609-89e6-4fc6-b4b3-bda2f3a90607");

    public static final int COUNT_OF_COMMENTS = 50;
    public static final int COUNT_OF_NEWS = 5;



    private static final PostgreSQLContainer<?> container = new PostgreSQLContainer<>("postgres:14.7");

    @BeforeAll
    static void runContainer(){
        container.start();
    }

    @DynamicPropertySource
    static void postgresProperties(DynamicPropertyRegistry registry){
        registry.add("spring.datasource.url", container::getJdbcUrl);
    }

    protected static String camelToSnake(String str){
        return str.replaceAll("([A-Z][a-z])", "_$1").toLowerCase();
    }
}
