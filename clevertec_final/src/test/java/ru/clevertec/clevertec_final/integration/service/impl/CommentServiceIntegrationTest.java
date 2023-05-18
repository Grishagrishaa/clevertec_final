package ru.clevertec.clevertec_final.integration.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.test.context.support.WithMockUser;
import ru.clevertec.clevertec_final.controller.pagination.filter.CommentFilter;
import ru.clevertec.clevertec_final.dto.request.CommentCreateDto;
import ru.clevertec.clevertec_final.dto.response.CommentReadDto;
import ru.clevertec.clevertec_final.integration.BaseIntegrationTest;
import ru.clevertec.clevertec_final.service.CommentService;
import ru.clevertec.clevertec_final.testUtils.builder.impl.CommentTestBuilder;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;


class CommentServiceIntegrationTest extends BaseIntegrationTest {

    @Autowired
    private CommentService service;

    @Test
    void createUserShouldReturnReadDtoWithUuid() {
        CommentReadDto user = CommentTestBuilder.defaultValues().buildReadDto();

        CommentReadDto actual = service.create(CommentTestBuilder.defaultValues().buildCreateDto());

        assertThat(actual).isNotNull();
    }

    @Test
    void findByIdShouldReturnReadDto() {
        CommentReadDto actual = service.findById(UUID.fromString("e7dd4609-89e6-4fc6-b4b3-bda2f3a90607"));

        assertThat(actual).isNotNull();
        assertThat(actual.getUuid()).isEqualTo(COMMENT_UUID);
    }

    @Test
    void findByIdShouldThrowExceptionIfIdInvalid() {
        assertThatThrownBy(() -> service.findById(UUID.randomUUID()))
                .isInstanceOf(EntityNotFoundException.class);
    }

    @Test
    void findAllByCommentFilterPageableShouldReturnCorrectPage() {
        Page<CommentReadDto> actual = service
                .findAllByCommentFilterPageable(CommentFilter.defaultValues(), Pageable.unpaged());

        assertThat(actual).hasSize(COUNT_OF_COMMENTS);
    }

    @Test
    @WithMockUser(username = "user1", password = "test", authorities = "ADMIN")
    void updateByUuidShouldReturnUpdatedReadDto() {

        CommentCreateDto toUpdate = CommentTestBuilder.defaultValues().buildCreateDto();
        CommentReadDto notUpdated = service.findById(COMMENT_UUID);

        CommentReadDto updated = service.updateById(COMMENT_UUID, toUpdate);

        assertAll(
                () -> assertThat(notUpdated).isNotEqualTo(toUpdate),

                () -> assertThat(updated.getText()).isEqualTo(toUpdate.getText()),
                () -> assertThat(updated.getUsername()).isEqualTo(toUpdate.getUsername()),
                () -> assertThat(updated.getNewsUuid()).isEqualTo(toUpdate.getNewsUuid())
        );
    }

    @Test
    @WithMockUser(username = "user1", password = "test", authorities = "ADMIN")
    void deleteByIdShouldDeleteEntity() {
        service.deleteById(COMMENT_UUID);

        assertThatThrownBy(() -> service.findById(COMMENT_UUID))
                .isInstanceOf(EntityNotFoundException.class);
    }
}