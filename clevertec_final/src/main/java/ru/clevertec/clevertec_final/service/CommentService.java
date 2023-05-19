package ru.clevertec.clevertec_final.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.clevertec.clevertec_final.controller.pagination.filter.CommentFilter;
import ru.clevertec.clevertec_final.dto.request.CommentCreateDto;
import ru.clevertec.clevertec_final.dto.response.CommentReadDto;

import java.util.UUID;

public interface CommentService {

    /**
     * Create a new comment.
     *
     * @param createDto The DTO containing the information for creating the comment.
     * @return The created comment as a CommentReadDto.
     */
    CommentReadDto create(CommentCreateDto createDto);

    /**
     * Find a comment by its UUID.
     *
     * @param uuid The UUID of the comment.
     * @return The found comment as a CommentReadDto.
     */
    CommentReadDto findById(UUID uuid);

    /**
     * Find all comments based on a filter using pagination.
     *
     * @param filter   The filter to apply for comments.
     * @param pageable The pageable information for pagination.
     * @return A page of comments as a Page<CommentReadDto>.
     */
    Page<CommentReadDto> findAllByCommentFilterPageable(CommentFilter filter, Pageable pageable);

    /**
     * Update a comment by its UUID.
     *
     * @param uuid      The UUID of the comment to update.
     * @param createDto The DTO containing the updated information for the comment.
     * @return The updated comment as a CommentReadDto.
     */
    CommentReadDto updateById(UUID uuid, CommentCreateDto createDto);

    /**
     * Delete a comment by its UUID.
     *
     * @param uuid The UUID of the comment to delete.
     */
    void deleteById(UUID uuid);
}