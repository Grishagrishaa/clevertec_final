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

@RestController
@RequestMapping("${app.newsController.path}")
@RequiredArgsConstructor
@OpenAPIDefinition(info = @Info(title = "Apply Default Global SecurityScheme", version = "1.0.0"))
public class NewsController {

    private final NewsService service;

    @RequestMapping(method = POST)
    @SecurityRequirement(name = "api_key")
    public ResponseEntity<NewsReadDto> create(@RequestBody  NewsCreateDto createDto){
        return ResponseEntity.status(CREATED).body(service.create(createDto));
    }

    @RequestMapping(method = GET, path = "/{uuid}")
    public ResponseEntity<NewsReadDto> findById(@PathVariable UUID uuid){
        return ResponseEntity.status(OK).body(service.findById(uuid));
    }

    @RequestMapping(method = GET, path = "/overview/{uuid}")
    public ResponseEntity<NewsWithCommentsReadDto> findByIdWithPageableComments(@PathVariable UUID uuid, @PageableDefault Pageable pageable){
        return ResponseEntity.status(OK).body(service.findByIdWithCommentsPageable(uuid, pageable));
    }

    @RequestMapping(method = GET)
    public ResponseEntity<Page<NewsReadDto>> findAllByNewsFilterPageable(@Valid NewsFilter filter, @PageableDefault Pageable pageable){
        return ResponseEntity.status(OK).body(service.findAllByNewsFilterPageable(filter, pageable));
    }

    @RequestMapping(method = PUT, path = "/{uuid}")
    @SecurityRequirement(name = "api_key")
    public ResponseEntity<NewsReadDto> updateById(@PathVariable UUID uuid, @RequestBody NewsCreateDto createDto){
        return ResponseEntity.status(ACCEPTED).body(service.updateById(uuid, createDto));
    }

    @RequestMapping(method = DELETE, path = "/{uuid}")
    @SecurityRequirement(name = "api_key")
    public ResponseEntity<?> deleteById(@PathVariable UUID uuid){
        service.deleteById(uuid);
        return ResponseEntity.status(NO_CONTENT).build();
    }

}
