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
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import ru.clevertec.clevertec_final.controller.pagination.filter.CommentFilter;
import ru.clevertec.clevertec_final.dto.request.CommentCreateDto;
import ru.clevertec.clevertec_final.dto.response.CommentReadDto;
import ru.clevertec.clevertec_final.repository.api.CommentRepository;
import ru.clevertec.clevertec_final.repository.entity.Comment;
import ru.clevertec.clevertec_final.service.impl.CommentServiceImpl;
import ru.clevertec.clevertec_final.service.mapper.CommentMapper;
import ru.clevertec.clevertec_final.testUtils.builder.impl.CommentTestBuilder;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CommentServiceImplTest {

    @Mock
    private CommentRepository repository;
    @Spy
    private CommentMapper mapper = Mappers.getMapper(CommentMapper.class);
    @InjectMocks
    private CommentServiceImpl service;


    @Test
    void createShouldReturnReadDto() {
        Comment comment = CommentTestBuilder.defaultValues().build();
        CommentCreateDto createDto = CommentTestBuilder.toCreateDto(comment);

        doReturn(comment)
                .when(repository).save(any());

        CommentReadDto actual = service.create(createDto);
        CommentReadDto expected = CommentTestBuilder.defaultValues().buildReadDto();


        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void findByIdShouldReturnReadDto() {
        Comment comment = CommentTestBuilder.defaultValues().build();

        doReturn(Optional.ofNullable(comment))
                .when(repository).findById(comment.getUuid());

        CommentReadDto expected = CommentTestBuilder.toReadDto(comment);
        CommentReadDto actual = service.findById(comment.getUuid());

        verify(repository).findById(comment.getUuid());
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void findByIdShouldThrowExceptionIfIdIncorrect() {

        doReturn(Optional.empty())
                .when(repository).findById(any());

        assertThatThrownBy(() -> service.findById(any()))
                .isInstanceOf(EntityNotFoundException.class);
    }

    @Test
    void findAllByCommentFilterPageableShouldReturnCorrectPage() {
        Comment comment = CommentTestBuilder.defaultValues().build();
        CommentReadDto readDto = CommentTestBuilder.toReadDto(comment);
        Page<CommentReadDto> expected = new PageImpl<>(List.of(readDto));

        doReturn(new PageImpl<>(List.of(comment)))
                .when(repository).findAll(any(Specification.class), any(Pageable.class));

        Page<CommentReadDto> actual = service.findAllByCommentFilterPageable(CommentFilter.defaultValues(), Pageable.unpaged());

        assertThat(actual.getContent()).isEqualTo(expected.getContent());
    }

    @Test
    void updateByIdShouldCallRepository() {
        CommentCreateDto updateDto = CommentTestBuilder.defaultValues().buildCreateDto();
        Comment comment = CommentTestBuilder.defaultValues().build();

        doReturn(comment)
                .when(repository).getReferenceById(comment.getUuid());

        service.updateById(comment.getUuid(), updateDto);

        verify(repository).getReferenceById(comment.getUuid());
        verify(repository).save(comment);
    }

    @Test
    void updateByIdShouldThrowEntityNotFoundException() {
        CommentCreateDto updateDto = CommentTestBuilder.defaultValues().buildCreateDto();

        doThrow(EntityNotFoundException.class)
                .when(repository).getReferenceById(any());

        assertThatThrownBy(() -> service.updateById(any(), updateDto))
                .isInstanceOf(EntityNotFoundException.class);
    }

    @Test
    void deleteByIdShouldCallRepository() {
        Comment comment = CommentTestBuilder.defaultValues().build();

        doReturn(Optional.of(comment))
                .when(repository).findById(comment.getUuid());

        service.deleteById(comment.getUuid());

        verify(repository).findById(comment.getUuid());
        verify(repository).delete(comment);
    }

    @Test
    void deleteByIdShouldThrowEntityNotFoundException() {
        doReturn(Optional.empty())
                .when(repository).findById(any());

        assertThatThrownBy(() -> service.deleteById(any()))
                .isInstanceOf(EntityNotFoundException.class);
    }
}