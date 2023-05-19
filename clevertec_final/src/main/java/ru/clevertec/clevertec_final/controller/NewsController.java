package ru.clevertec.clevertec_final.controller;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.clevertec.clevertec_final.controller.pagination.filter.NewsFilter;
import ru.clevertec.clevertec_final.dto.request.NewsCreateDto;
import ru.clevertec.clevertec_final.dto.response.NewsReadDto;
import ru.clevertec.clevertec_final.dto.response.NewsWithCommentsReadDto;
import ru.clevertec.clevertec_final.service.NewsService;

import java.util.UUID;

import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

/**
 * Controller for managing news.
 */
@RestController
@RequestMapping("${app.newsController.path}")
@RequiredArgsConstructor
@OpenAPIDefinition(info = @Info(title = "Apply Default Global SecurityScheme", version = "1.0.0"))
public class NewsController {

    private final NewsService service;

    /**
     * Creates a new news article.
     *
     * @param createDto The DTO containing the news article data.
     * @return The created news article as a response entity.
     */
    @RequestMapping(method = POST)
    @SecurityRequirement(name = "api_key")
    public ResponseEntity<NewsReadDto> create(@RequestBody NewsCreateDto createDto) {
        return ResponseEntity.status(CREATED).body(service.create(createDto));
    }

    /**
     * Retrieves a news article by its UUID.
     *
     * @param uuid The UUID of the news article.
     * @return The retrieved news article as a response entity.
     */
    @RequestMapping(method = GET, path = "/{uuid}")
    public ResponseEntity<NewsReadDto> findById(@PathVariable UUID uuid) {
        return ResponseEntity.status(OK).body(service.findById(uuid));
    }

    /**
     * Retrieves a news article with pageable comments by its UUID.
     *
     * @param uuid     The UUID of the news article.
     * @param pageable The pageable parameters.
     * @return The retrieved news article with pageable comments as a response entity.
     */
    @RequestMapping(method = GET, path = "/overview/{uuid}")
    public ResponseEntity<NewsWithCommentsReadDto> findByIdWithPageableComments(
            @PathVariable UUID uuid, @PageableDefault Pageable pageable) {
        return ResponseEntity.status(OK).body(service.findByIdWithCommentsPageable(uuid, pageable));
    }

    /**
     * Retrieves news articles based on the provided filter and pageable parameters.
     *
     * @param filter   The news filter.
     * @param pageable The pageable parameters.
     * @return The paginated list of news articles as a response entity.
     */
    @RequestMapping(method = GET)
    public ResponseEntity<Page<NewsReadDto>> findAllByNewsFilterPageable(
            @Valid NewsFilter filter, @PageableDefault Pageable pageable) {
        return ResponseEntity.status(OK).body(service.findAllByNewsFilterPageable(filter, pageable));
    }

    /**
     * Updates a news article by its UUID.
     *
     * @param uuid      The UUID of the news article.
     * @param createDto The DTO containing the updated news article data.
     * @return The updated news article as a response entity.
     */
    @RequestMapping(method = PUT, path = "/{uuid}")
    @SecurityRequirement(name = "api_key")
    public ResponseEntity<NewsReadDto> updateById(
            @PathVariable UUID uuid, @RequestBody NewsCreateDto createDto) {
        return ResponseEntity.status(ACCEPTED).body(service.updateById(uuid, createDto));
    }

    /**
     * Deletes a news article by its UUID.
     *
     * @param uuid The UUID of the news article.
     * @return The response entity indicating success or failure.
     */
    @RequestMapping(method = DELETE, path = "/{uuid}")
    @SecurityRequirement(name = "api_key")
    public ResponseEntity<?> deleteById(@PathVariable UUID uuid) {
        service.deleteById(uuid);
        return ResponseEntity.status(NO_CONTENT).build();
    }
}

