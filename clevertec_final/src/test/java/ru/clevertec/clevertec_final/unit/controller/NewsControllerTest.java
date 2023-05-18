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
import ru.clevertec.clevertec_final.controller.NewsController;
import ru.clevertec.clevertec_final.controller.pagination.filter.NewsFilter;
import ru.clevertec.clevertec_final.dto.request.NewsCreateDto;
import ru.clevertec.clevertec_final.dto.response.NewsReadDto;
import ru.clevertec.clevertec_final.service.NewsService;
import ru.clevertec.clevertec_final.testUtils.builder.impl.NewsTestBuilder;

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
class NewsControllerTest {

    @Mock
    private NewsService service;
    @InjectMocks
    private NewsController controller;

    @Test
    void createShouldReturnCorrectReadDto() {
        NewsReadDto readDto = NewsTestBuilder.defaultValues().buildReadDto();
        NewsCreateDto createDto = NewsTestBuilder.defaultValues().buildCreateDto();

        doReturn(readDto)
                .when(service).create(createDto);

        ResponseEntity<NewsReadDto> expected = ResponseEntity.status(CREATED).body(readDto);
        ResponseEntity<NewsReadDto> actual = controller.create(createDto);

        verify(service).create(createDto);
        assertThat(expected).isEqualTo(actual);
    }

    @Test
    void findByIdShouldReturnCorrectReadDto() {
        NewsReadDto readDto = NewsTestBuilder.defaultValues().buildReadDto();

        doReturn(readDto)
                .when(service).findById(readDto.getUuid());

        ResponseEntity<NewsReadDto> expected = ResponseEntity.ok().body(readDto);
        ResponseEntity<NewsReadDto> actual = controller.findById(readDto.getUuid());

        verify(service).findById(readDto.getUuid());
        assertThat(expected).isEqualTo(actual);
    }

    @Test
    void findByIdWithPageableComments() {
    }

    @Test
    void findAllByNewsFilterPageableShouldReturnCorrectPage() {
        Page<NewsReadDto> page = new PageImpl<>(List.of( NewsTestBuilder.defaultValues().buildReadDto()));

        doReturn(page)
                .when(service).findAllByNewsFilterPageable(NewsFilter.defaultValues(), Pageable.unpaged());

        ResponseEntity<Page<NewsReadDto>> expected = ResponseEntity.ok().body(page);
        ResponseEntity<Page<NewsReadDto>> actual = controller
                               .findAllByNewsFilterPageable(NewsFilter.defaultValues(), Pageable.unpaged());

        assertThat(expected).isEqualTo(actual);
        verify(service).findAllByNewsFilterPageable(NewsFilter.defaultValues(), Pageable.unpaged());
    }

    @Test
    void updateByIdShouldReturnCorrectReadDto() {
        NewsReadDto readDto = NewsTestBuilder.defaultValues().buildReadDto();
        NewsCreateDto updateDto = NewsTestBuilder.defaultValues().buildCreateDto();

        doReturn(readDto)
                .when(service).updateById(readDto.getUuid(), updateDto);

        ResponseEntity<NewsReadDto> expected = ResponseEntity.accepted().body(readDto);
        ResponseEntity<NewsReadDto> actual = controller.updateById(readDto.getUuid(), updateDto);

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