package ru.clevertec.clevertec_final.service;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import ru.clevertec.clevertec_final.controller.pagination.filter.NewsFilter;
import ru.clevertec.clevertec_final.dto.request.NewsCreateDto;
import ru.clevertec.clevertec_final.dto.response.NewsReadDto;
import ru.clevertec.clevertec_final.dto.response.NewsWithCommentsReadDto;

import java.util.UUID;

@Validated
public interface NewsService {

    NewsReadDto create(@Valid NewsCreateDto createDto);

    NewsReadDto findById(UUID uuid);

    NewsWithCommentsReadDto findByIdWithCommentsPageable(UUID uuid, Pageable pageable);

    Page<NewsReadDto> findAllByNewsFilterPageable(NewsFilter filter, Pageable pageable);

    NewsReadDto updateById(UUID uuid, @Valid NewsCreateDto createDto);

    void deleteById(UUID uuid);

}
