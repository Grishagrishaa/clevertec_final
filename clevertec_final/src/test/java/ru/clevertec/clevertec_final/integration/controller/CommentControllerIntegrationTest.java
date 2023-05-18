package ru.clevertec.clevertec_final.integration.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.client.WireMock;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.User;
import org.springframework.test.web.servlet.MockMvc;
import ru.clevertec.clevertec_final.dto.response.CommentReadDto;
import ru.clevertec.clevertec_final.integration.BaseIntegrationTest;
import ru.clevertec.clevertec_final.integration.WireMockExtension;
import ru.clevertec.clevertec_final.repository.entity.Comment;
import ru.clevertec.clevertec_final.security.enums.ERole;
import ru.clevertec.clevertec_final.testUtils.builder.impl.CommentTestBuilder;

import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@ExtendWith({MockitoExtension.class, WireMockExtension.class})
class CommentControllerIntegrationTest extends BaseIntegrationTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Value("${app.commentController.path}")
    private String path;

    @Value("app.test.token")
    private String BEARER_TOKEN;

    @Test
    @SneakyThrows
    void createShouldReturnCorrectReadDto() {
        String content = objectMapper.writeValueAsString(CommentTestBuilder.defaultValues().buildCreateDto());

        stubFor(WireMock.get(urlEqualTo("/api/v1/users/me"))
                .withHeader(HttpHeaders.AUTHORIZATION, equalTo("Bearer " + BEARER_TOKEN))
                .willReturn(aResponse()
                        .withStatus(OK.value())));

        mockMvc.perform(post(String.format("/%s", path))
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .header(HttpHeaders.AUTHORIZATION, "Bearer " + BEARER_TOKEN)
                        .content(content))

                .andExpectAll(
                        status().isCreated(),
                        content().contentType(MediaType.APPLICATION_JSON),

                        jsonPath("$." + camelToSnake(CommentReadDto.Fields.createdDate)).isNotEmpty(),
                        jsonPath("$." + camelToSnake(CommentReadDto.Fields.uuid)).isNotEmpty(),
                        jsonPath("$." + camelToSnake(CommentReadDto.Fields.text)).isNotEmpty(),
                        jsonPath("$." + camelToSnake(CommentReadDto.Fields.username)).isNotEmpty(),
                        jsonPath("$." + camelToSnake(CommentReadDto.Fields.modifiedBy)).isNotEmpty()
                );
    }

    @Test
    @SneakyThrows
    void findByIdShouldReturnCorrectReadDto() {
        mockMvc.perform(get(String.format("/%s/{id}", path), COMMENT_UUID)
                        .contentType(MediaType.APPLICATION_JSON_VALUE))


                .andExpectAll(
                        status().isOk(),
                        content().contentType(MediaType.APPLICATION_JSON),

                        jsonPath("$." + camelToSnake(CommentReadDto.Fields.createdDate)).isNotEmpty(),
                        jsonPath("$." + camelToSnake(CommentReadDto.Fields.uuid)).isNotEmpty(),
                        jsonPath("$." + camelToSnake(CommentReadDto.Fields.text)).isNotEmpty(),
                        jsonPath("$." + camelToSnake(CommentReadDto.Fields.username)).isNotEmpty(),
                        jsonPath("$." + camelToSnake(CommentReadDto.Fields.modifiedBy)).isNotEmpty()
                );
    }


    @Test
    @SneakyThrows
    void findAllByCommentFilterPageableShouldReturnCorrectSizePage() {
        int expectedSize = 1;

        mockMvc.perform(get(String.format("/%s", path))
                        .param("page", "0")
                        .param("size", Integer.toString(expectedSize))
                        .param("title", "Sample desc0")

                        .contentType(MediaType.APPLICATION_JSON_VALUE))

                .andExpectAll(
                        status().isOk(),
                        jsonPath("$.content").isNotEmpty(),
                        jsonPath("$.content.length()").value(expectedSize)
                );
    }

    @Test
    @SneakyThrows
    void updateByIdShouldReturnCorrectUpdatedReadDto() {
        String content = objectMapper
                .writeValueAsString(CommentTestBuilder.defaultValues().buildCreateDto());

        stubFor(WireMock.get(urlEqualTo("/api/v1/users/me"))
                .withHeader(HttpHeaders.AUTHORIZATION, equalTo("Bearer " + BEARER_TOKEN))
                .willReturn(aResponse()
                        .withBody(objectMapper.writeValueAsString(new User("test", "test", List.of(ERole.ADMIN))))
                        .withStatus(NO_CONTENT.value())));

        mockMvc.perform(put(String.format("/%s/{id}", path), COMMENT_UUID)
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + BEARER_TOKEN))


                .andExpectAll(
                        status().isAccepted(),
                        content().contentType(MediaType.APPLICATION_JSON),

                        jsonPath("$." + camelToSnake(CommentReadDto.Fields.createdDate)).isNotEmpty(),
                        jsonPath("$." + camelToSnake(CommentReadDto.Fields.uuid)).isNotEmpty(),
                        jsonPath("$." + camelToSnake(CommentReadDto.Fields.text)).isNotEmpty(),
                        jsonPath("$." + camelToSnake(CommentReadDto.Fields.username)).isNotEmpty(),
                        jsonPath("$." + camelToSnake(CommentReadDto.Fields.modifiedBy)).isNotEmpty()
                );
    }



    @Test
    @SneakyThrows
    void deleteByIdShouldReturn2xxStatus() {
        stubFor(WireMock.get(urlEqualTo("/api/v1/users/me"))
                .withHeader(HttpHeaders.AUTHORIZATION, equalTo("Bearer " + BEARER_TOKEN))
                .willReturn(aResponse()
                        .withBody(objectMapper.writeValueAsString(new User("test", "test", List.of(ERole.ADMIN))))
                        .withStatus(NO_CONTENT.value())));

        mockMvc.perform(delete(String.format("/%s/{id}", path), COMMENT_UUID)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + BEARER_TOKEN))

                .andExpect(status().is2xxSuccessful());
    }
}