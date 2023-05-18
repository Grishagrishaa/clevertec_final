package ru.clevertec.clevertec_final.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.clevertec.clevertec_final.controller.pagination.filter.CommentFilter;
import ru.clevertec.clevertec_final.dto.request.CommentCreateDto;
import ru.clevertec.clevertec_final.dto.response.CommentReadDto;

import java.util.UUID;

public interface CommentService {

    CommentReadDto create(CommentCreateDto createDto);

    CommentReadDto findById(UUID uuid);

    Page<CommentReadDto> findAllByCommentFilterPageable(CommentFilter filter, Pageable pageable);

    CommentReadDto updateById(UUID uuid, CommentCreateDto createDto);

    void deleteById(UUID uuid);

}
