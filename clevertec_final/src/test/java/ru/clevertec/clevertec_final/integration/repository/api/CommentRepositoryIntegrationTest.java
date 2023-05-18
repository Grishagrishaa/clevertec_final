package ru.clevertec.clevertec_final.integration.repository.api;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import ru.clevertec.clevertec_final.integration.BaseIntegrationTest;
import ru.clevertec.clevertec_final.repository.api.CommentRepository;
import ru.clevertec.clevertec_final.repository.entity.Comment;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class CommentRepositoryIntegrationTest extends BaseIntegrationTest {
    @Autowired
    private CommentRepository repository;

    @Test
    void findByNickShouldReturnCorrectPage(){
        List<Comment> actual = repository.findAllByNewsUuid(NEWS_UUID, Pageable.unpaged());

        assertThat(actual).hasSize(COUNT_OF_COMMENTS);
    }

    @Test
    void findByNickShouldReturnEmptyPageIfNickIncorrect(){
        List<Comment> actual = repository.findAllByNewsUuid(UUID.randomUUID(), Pageable.unpaged());

        assertThat(actual).isEmpty();
    }
}