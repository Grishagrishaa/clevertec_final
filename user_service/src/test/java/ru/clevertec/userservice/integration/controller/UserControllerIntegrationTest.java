package ru.clevertec.userservice.integration.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.clevertec.userservice.dto.JwtResponse;
import ru.clevertec.userservice.integration.BaseIntegrationTest;
import ru.clevertec.userservice.repository.entity.User;
import ru.clevertec.userservice.security.UserDetailsUser;
import ru.clevertec.userservice.testUtils.builder.impl.UserTestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
class UserControllerIntegrationTest extends BaseIntegrationTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Value("${app.users.url}")
    private String path;

    @Test
    @SneakyThrows
    void createShouldReturnCorrectUser() {
        String content = objectMapper.writeValueAsString(UserTestBuilder.defaultValues().buildCreateDto());

        mockMvc.perform(post(String.format("/%s", path))
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(content))

                .andExpectAll(
                        status().isCreated(),
                        content().contentType(MediaType.APPLICATION_JSON),

                        jsonPath("$." + camelToSnake(User.Fields.createDate)).isNotEmpty(),
                        jsonPath("$." + camelToSnake(User.Fields.updateDate)).isNotEmpty(),
                        jsonPath("$." + camelToSnake(User.Fields.mail)).isNotEmpty(),
                        jsonPath("$." + camelToSnake(User.Fields.nick)).isNotEmpty(),
                        jsonPath("$." + camelToSnake(User.Fields.role)).isNotEmpty(),
                        jsonPath("$." + camelToSnake(User.Fields.status)).isNotEmpty()
                );
    }

    @Test
    @SneakyThrows
    void findByIdShouldReturnCorrectUser() {
        mockMvc.perform(get(String.format("/%s/{id}", path), LAST_ENTITY_UUID)
                        .contentType(MediaType.APPLICATION_JSON_VALUE))

                .andExpectAll(
                        status().isOk(),
                        content().contentType(MediaType.APPLICATION_JSON),

                        jsonPath("$." + camelToSnake(User.Fields.uuid)).value(LAST_ENTITY_UUID.toString()),
                        jsonPath("$." + camelToSnake(User.Fields.createDate)).isNotEmpty(),
                        jsonPath("$." + camelToSnake(User.Fields.updateDate)).isNotEmpty(),
                        jsonPath("$." + camelToSnake(User.Fields.mail)).isNotEmpty(),
                        jsonPath("$." + camelToSnake(User.Fields.nick)).isNotEmpty(),
                        jsonPath("$." + camelToSnake(User.Fields.role)).isNotEmpty(),
                        jsonPath("$." + camelToSnake(User.Fields.status)).isNotEmpty()
                );
    }

    @Test
    @SneakyThrows
    void findAllPageableShouldReturnCorrectSizePage() {
        int expectedSize = 5;

        mockMvc.perform(get(String.format("/%s", path))
                        .param("page", "0")
                        .param("size", Integer.toString(expectedSize))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))

                .andExpectAll(
                        status().isOk(),
                        jsonPath("$.content").isNotEmpty(),
                        jsonPath("$.content.length()").value(expectedSize)
                );
    }

    @Test
    @SneakyThrows
    void updateByUuidShouldReturnCorrectUpdatedReadDto(){
        String content = objectMapper
                .writeValueAsString(UserTestBuilder.defaultValues().buildCreateDto());

        mockMvc.perform(put(String.format("/%s/{id}", path), LAST_ENTITY_UUID)
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON_VALUE))

                .andExpectAll(
                        status().isOk(),
                        content().contentType(MediaType.APPLICATION_JSON),

                        jsonPath("$." + camelToSnake(User.Fields.uuid)).value(LAST_ENTITY_UUID.toString()),
                        jsonPath("$." + camelToSnake(User.Fields.createDate)).isNotEmpty(),
                        jsonPath("$." + camelToSnake(User.Fields.updateDate)).isNotEmpty(),
                        jsonPath("$." + camelToSnake(User.Fields.mail)).isNotEmpty(),
                        jsonPath("$." + camelToSnake(User.Fields.nick)).isNotEmpty(),
                        jsonPath("$." + camelToSnake(User.Fields.role)).isNotEmpty(),
                        jsonPath("$." + camelToSnake(User.Fields.status)).isNotEmpty()
                );
    }

    @Test
    @SneakyThrows
    void registrationShouldReturnCreatedStatus() {
        String content = objectMapper
                .writeValueAsString(UserTestBuilder.toSignDto(UserTestBuilder.defaultValues().build()));

        mockMvc.perform(post(String.format("/%s/registration", path))
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON_VALUE))

                .andExpect(status().isCreated());
    }

    @Test
    @SneakyThrows
    void loginShouldReturnJwtResponse() {
        String content = objectMapper
                .writeValueAsString(UserTestBuilder.toLoginDto(UserTestBuilder.defaultValues().build()));

        mockMvc.perform(post(String.format("/%s/login", path))
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON_VALUE))

                .andExpectAll(
                        status().isAccepted(),
                        content().contentType(MediaType.APPLICATION_JSON),

                        jsonPath("$." + camelToSnake(JwtResponse.Fields.username)).isNotEmpty(),
                        jsonPath("$." + camelToSnake(JwtResponse.Fields.authorities)).isNotEmpty(),
                        jsonPath("$." + camelToSnake(JwtResponse.Fields.activated)).isNotEmpty(),
                        jsonPath("$." + camelToSnake(JwtResponse.Fields.jwtToken)).isNotEmpty(),
                        jsonPath("$." + camelToSnake(JwtResponse.Fields.type)).isNotEmpty()
                );
    }

    @Test
    @SneakyThrows
    void getUserDetails() {
        mockMvc.perform(get(String.format("/%s/me", path))
                .contentType(MediaType.APPLICATION_JSON_VALUE))

                .andExpectAll(
                        status().isOk(),
                        content().contentType(MediaType.APPLICATION_JSON),

                        jsonPath("$." + camelToSnake(UserDetailsUser.Fields.username)).isNotEmpty(),
                        jsonPath("$." + camelToSnake(UserDetailsUser.Fields.authorities)).isNotEmpty(),
                        jsonPath("$." + camelToSnake(UserDetailsUser.Fields.accountNonExpired)).isNotEmpty(),
                        jsonPath("$." + camelToSnake(UserDetailsUser.Fields.credentialsNonExpired)).isNotEmpty()
                );
    }
}