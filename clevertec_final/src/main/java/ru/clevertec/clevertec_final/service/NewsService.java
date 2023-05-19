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

    /**
     * Create a new news item.
     *
     * @param createDto The DTO containing the information for creating the news item.
     * @return The created news item as a NewsReadDto.
     */
    NewsReadDto create(@Valid NewsCreateDto createDto);

    /**
     * Find a news item by its UUID.
     *
     * @param uuid The UUID of the news item.
     * @return The found news item as a NewsReadDto.
     */
    NewsReadDto findById(UUID uuid);

    /**
     * Find a news item with comments by its UUID using pagination.
     *
     * @param uuid     The UUID of the news item.
     * @param pageable The pageable information for pagination.
     * @return The found news item with comments as a NewsWithCommentsReadDto.
     */
    NewsWithCommentsReadDto findByIdWithCommentsPageable(UUID uuid, Pageable pageable);

    /**
     * Find all news items based on a filter using pagination.
     *
     * @param filter   The filter to apply for news items.
     * @param pageable The pageable information for pagination.
     * @return A page of news items as a Page<NewsReadDto>.
     */
    Page<NewsReadDto> findAllByNewsFilterPageable(NewsFilter filter, Pageable pageable);

    /**
     * Update a news item by its UUID.
     *
     * @param uuid      The UUID of the news item to update.
     * @param createDto The DTO containing the updated information for the news item.
     * @return The updated news item as a NewsReadDto.
     */
    NewsReadDto updateById(UUID uuid, @Valid NewsCreateDto createDto);

    /**
     * Delete a news item by its UUID.
     *
     * @param uuid The UUID of the news item to delete.
     */
    void deleteById(UUID uuid);

}
