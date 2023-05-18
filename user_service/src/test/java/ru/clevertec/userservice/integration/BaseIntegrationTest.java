package ru.clevertec.userservice.integration;

import org.junit.jupiter.api.BeforeAll;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import ru.clevertec.userservice.integration.annotation.IT;

import java.util.UUID;

@IT
@WithMockUser(username = "user1", password = "test", authorities = "ADMIN")
public abstract class BaseIntegrationTest {

    public static final UUID LAST_ENTITY_UUID = UUID.fromString("ea2e11af-51a5-4b4c-9a75-81547b3b0bc7");
    public static final String LAST_ENTITY_NICK = "user10";
    public static final int COUNT_OF_ENTITIES = 10;


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
