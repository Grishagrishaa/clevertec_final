package ru.clevertec.clevertec_final.integration.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.test.context.support.WithMockUser;
import ru.clevertec.clevertec_final.controller.pagination.filter.NewsFilter;
import ru.clevertec.clevertec_final.dto.request.NewsCreateDto;
import ru.clevertec.clevertec_final.dto.response.NewsReadDto;
import ru.clevertec.clevertec_final.dto.response.NewsWithCommentsReadDto;
import ru.clevertec.clevertec_final.integration.BaseIntegrationTest;
import ru.clevertec.clevertec_final.service.NewsService;
import ru.clevertec.clevertec_final.testUtils.builder.impl.NewsTestBuilder;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;


class NewsServiceIntegrationTest extends BaseIntegrationTest {

    @Autowired
    private NewsService service;

    @Test
    void createUserShouldReturnReadDtoWithUuid() {
        NewsReadDto actual = service.create(NewsTestBuilder.defaultValues().buildCreateDto());

        assertThat(actual).isNotNull();
    }

    @Test
    void findByIdShouldReturnReadDto() {
        NewsReadDto actual = service.findById(NEWS_UUID);

        assertThat(actual).isNotNull();
        assertThat(actual.getUuid()).isEqualTo(NEWS_UUID);
    }

    @Test
    void findByIdShouldThrowExceptionIfIdInvalid() {
        assertThatThrownBy(() -> service.findById(UUID.randomUUID()))
                .isInstanceOf(EntityNotFoundException.class);
    }

//    @Override
//    public NewsWithCommentsReadDto findByIdWithCommentsPageable(UUID uuid, Pageable pageable) {
//        News news = newsRepository.findById(uuid)
//                .orElseThrow(EntityNotFoundException::new);
//        List<Comment> comments = commentRepository.findAllByNewsUuid(uuid, pageable);
//
//        return mapper.entityToReadDtoWithComments(news, comments);
//    }

    @Test
    void findByIdWithCommentsPageable(){
        int expectedSize = 5;
        NewsWithCommentsReadDto readDtoWithComments = service
                .findByIdWithCommentsPageable(NEWS_UUID, PageRequest.of(0, expectedSize));

        assertThat(readDtoWithComments.getComments()).hasSize(expectedSize);
    }


    @Test
    void findAllByCommentFilterPageableShouldReturnCorrectPage() {
        Page<NewsReadDto> actual = service
                .findAllByNewsFilterPageable(NewsFilter.defaultValues(), Pageable.unpaged());

        assertThat(actual).hasSize(COUNT_OF_NEWS);
    }

    @Test
    @WithMockUser(username = "user1", password = "test", authorities = "ADMIN")
    void updateByUuidShouldReturnUpdatedReadDto() {
        NewsCreateDto toUpdate = NewsTestBuilder.defaultValues().buildCreateDto();
        NewsReadDto notUpdated = service.findById(NEWS_UUID);

        NewsReadDto updated = service.updateById(NEWS_UUID, toUpdate);

        assertAll(
                () -> assertThat(notUpdated).isNotEqualTo(toUpdate),
                () -> assertThat(updated.getText()).isEqualTo(toUpdate.getText()),
                () -> assertThat(updated.getTitle()).isEqualTo(toUpdate.getTitle())
        );
    }

    @Test
    @WithMockUser(username = "user1", password = "test", authorities = "ADMIN")
    void deleteByIdShouldDeleteEntity() {
        service.deleteById(NEWS_UUID);

        assertThatThrownBy(() -> service.findById(NEWS_UUID))
                .isInstanceOf(EntityNotFoundException.class);
    }
}