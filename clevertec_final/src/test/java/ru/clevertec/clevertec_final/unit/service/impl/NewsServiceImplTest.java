package ru.clevertec.clevertec_final.unit.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import ru.clevertec.clevertec_final.controller.pagination.filter.NewsFilter;
import ru.clevertec.clevertec_final.dto.request.NewsCreateDto;
import ru.clevertec.clevertec_final.dto.response.NewsReadDto;
import ru.clevertec.clevertec_final.dto.response.NewsWithCommentsReadDto;
import ru.clevertec.clevertec_final.repository.api.CommentRepository;
import ru.clevertec.clevertec_final.repository.api.NewsRepository;
import ru.clevertec.clevertec_final.repository.entity.Comment;
import ru.clevertec.clevertec_final.repository.entity.News;
import ru.clevertec.clevertec_final.service.impl.NewsServiceImpl;
import ru.clevertec.clevertec_final.service.mapper.CommentMapper;
import ru.clevertec.clevertec_final.service.mapper.NewsMapper;
import ru.clevertec.clevertec_final.testUtils.builder.impl.CommentTestBuilder;
import ru.clevertec.clevertec_final.testUtils.builder.impl.NewsTestBuilder;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class NewsServiceImplTest {

    @Mock
    private NewsRepository newsRepository;
    @Mock
    private CommentRepository commentRepository;
    @Spy
    private NewsMapper newsMapper = Mappers.getMapper(NewsMapper.class);
    @InjectMocks
    private NewsServiceImpl service;

    @Test
    void createShouldReturnReadDto() {
        News news = NewsTestBuilder.defaultValues().build();
        NewsCreateDto createDto = NewsTestBuilder.toCreateDto(news);

        doReturn(news)
                .when(newsRepository).save(any());

        NewsReadDto actual = service.create(createDto);
        NewsReadDto expected = NewsTestBuilder.defaultValues().buildReadDto();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void findByIdShouldReturnReadDto() {
        News news = NewsTestBuilder.defaultValues().build();

        doReturn(Optional.ofNullable(news))
                .when(newsRepository).findById(news.getUuid());

        NewsReadDto actual = service.findById(news.getUuid());
        NewsReadDto expected = NewsTestBuilder.toReadDto(news);

        verify(newsRepository).findById(news.getUuid());
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void findByIdWithCommentsPageableShouldReturnCorrectPage() {
        News news = NewsTestBuilder.defaultValues().build();
        List<Comment> comments = List.of(CommentTestBuilder.defaultValues().build());
        NewsWithCommentsReadDto expected = NewsTestBuilder.defaultValues().buildReadDtoWithTags();

        doReturn(Optional.ofNullable(news))
                .when(newsRepository).findById(news.getUuid());
        doReturn(comments)
                .when(commentRepository).findAllByNewsUuid(news.getUuid(), Pageable.unpaged());
        doReturn(expected)
                .when(newsMapper).entityToReadDtoWithComments(news, comments);

        NewsWithCommentsReadDto actual = service
                        .findByIdWithCommentsPageable(news.getUuid(), Pageable.unpaged());

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void findAllByNewsFilterPageableShouldReturnCorrectPage() {
        News news = NewsTestBuilder.defaultValues().build();
        NewsReadDto readDto = NewsTestBuilder.toReadDto(news);
        Page<NewsReadDto> expected = new PageImpl<>(List.of(readDto));

        doReturn(new PageImpl<>(List.of(news)))
                .when(newsRepository).findAll(any(Specification.class), any(Pageable.class));

        Page<NewsReadDto> actual = service.findAllByNewsFilterPageable(NewsFilter.defaultValues(), Pageable.unpaged());

        assertThat(actual.getContent()).isEqualTo(expected.getContent());
    }

    @Test
    void updateByIdShouldCallRepository() {
        NewsCreateDto updateDto = NewsTestBuilder.defaultValues().buildCreateDto();
        News news = NewsTestBuilder.defaultValues().build();

        doReturn(news)
                .when(newsRepository).getReferenceById(news.getUuid());

        service.updateById(news.getUuid(), updateDto);

        verify(newsRepository).getReferenceById(news.getUuid());
        verify(newsRepository).save(news);
    }

    @Test
    void updateByIdShouldThrowEntityNotFoundException() {
        NewsCreateDto updateDto = NewsTestBuilder.defaultValues().buildCreateDto();

        doThrow(EntityNotFoundException.class)
                .when(newsRepository).getReferenceById(any());

        assertThatThrownBy(() -> service.updateById(any(), updateDto))
                .isInstanceOf(EntityNotFoundException.class);
    }

    @Test
    void deleteByIdShouldCallRepository() {
        News news = NewsTestBuilder.defaultValues().build();

        doReturn(Optional.of(news))
                .when(newsRepository).findById(news.getUuid());

        service.deleteById(news.getUuid());

        verify(newsRepository).findById(news.getUuid());
        verify(newsRepository).delete(news);
    }

    @Test
    void deleteByIdShouldThrowEntityNotFoundException() {
        doReturn(Optional.empty())
                .when(newsRepository).findById(any());

        assertThatThrownBy(() -> service.deleteById(any()))
                .isInstanceOf(EntityNotFoundException.class);
    }
}