package ru.clevertec.clevertec_final.unit.controller;

import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import ru.clevertec.clevertec_final.controller.CommentController;
import ru.clevertec.clevertec_final.controller.pagination.filter.CommentFilter;
import ru.clevertec.clevertec_final.dto.request.CommentCreateDto;
import ru.clevertec.clevertec_final.dto.response.CommentReadDto;
import ru.clevertec.clevertec_final.service.CommentService;
import ru.clevertec.clevertec_final.testUtils.builder.impl.CommentTestBuilder;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.springframework.http.HttpStatus.CREATED;


@ExtendWith(MockitoExtension.class)
class  CommentControllerTest {

    @Mock
    private CommentService service;
    @InjectMocks
    private CommentController controller;

    @Test
    void createShouldReturnCorrectReadDto() {
        CommentReadDto readDto = CommentTestBuilder.defaultValues().buildReadDto();
        CommentCreateDto createDto = CommentTestBuilder.defaultValues().buildCreateDto();

        doReturn(readDto)
                .when(service).create(createDto);

        ResponseEntity<CommentReadDto> expected = ResponseEntity.status(CREATED).body(readDto);
        ResponseEntity<CommentReadDto> actual = controller.create(createDto);

        verify(service).create(createDto);
        assertThat(expected).isEqualTo(actual);
    }

    @Test
    void findByIdShouldReturnCorrectReadDto() {
        CommentReadDto readDto = CommentTestBuilder.defaultValues().buildReadDto();

        doReturn(readDto)
                .when(service).findById(readDto.getUuid());

        ResponseEntity<CommentReadDto> expected = ResponseEntity.ok().body(readDto);
        ResponseEntity<CommentReadDto> actual = controller.findById(readDto.getUuid());

        verify(service).findById(readDto.getUuid());
        assertThat(expected).isEqualTo(actual);
    }

    @Test
    void findAllByCommentFilterPageableShouldReturnCorrectPage() {
        Page<CommentReadDto> page = new PageImpl<>(List.of( CommentTestBuilder.defaultValues().buildReadDto()));

        doReturn(page)
                .when(service).findAllByCommentFilterPageable(CommentFilter.defaultValues(), Pageable.unpaged());

        ResponseEntity<Page<CommentReadDto>> expected = ResponseEntity.ok().body(page);
        ResponseEntity<Page<CommentReadDto>> actual = controller.findAllByCommentFilterPageable(CommentFilter.defaultValues(), Pageable.unpaged());

        assertThat(expected).isEqualTo(actual);
        verify(service).findAllByCommentFilterPageable(CommentFilter.defaultValues(), Pageable.unpaged());
    }

    @Test
    void updateByIdShouldReturnCorrectReadDto() {
        CommentReadDto readDto = CommentTestBuilder.defaultValues().buildReadDto();
        CommentCreateDto updateDto = CommentTestBuilder.defaultValues().buildCreateDto();

        doReturn(readDto)
                .when(service).updateById(readDto.getUuid(), updateDto);

        ResponseEntity<CommentReadDto> expected = ResponseEntity.accepted().body(readDto);
        ResponseEntity<CommentReadDto> actual = controller.updateById(readDto.getUuid(), updateDto);

        assertThat(expected).isEqualTo(actual);
        verify(service).updateById(readDto.getUuid(), updateDto);
    }

    @Test
    void deleteByIdShouldCallService() {
        doNothing()
                .when(service).deleteById(any());

        controller.deleteById(any());

        verify(service).deleteById(any());
    }

    @Test
    void deleteByIdShouldThrowExceptionIfIdIncorrect() {
        doThrow(EntityNotFoundException.class)
                .when(service).deleteById(any());

        assertThatThrownBy(() -> controller.deleteById(any()))
                .isInstanceOf(EntityNotFoundException.class);
    }
}