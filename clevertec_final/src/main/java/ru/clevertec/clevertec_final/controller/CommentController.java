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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.clevertec.clevertec_final.controller.pagination.filter.CommentFilter;
import ru.clevertec.clevertec_final.dto.request.CommentCreateDto;
import ru.clevertec.clevertec_final.dto.response.CommentReadDto;
import ru.clevertec.clevertec_final.service.CommentService;

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
@RequestMapping("${app.commentController.path}")
@RequiredArgsConstructor
@OpenAPIDefinition(info = @Info(title = "Apply Default Global SecurityScheme", version = "1.0.0"))
public class CommentController {

    private final CommentService service;

    @RequestMapping(method = POST)
    @SecurityRequirement(name = "api_key")
    public ResponseEntity<CommentReadDto> create(@RequestBody CommentCreateDto createDto){
        return ResponseEntity.status(CREATED).body(service.create(createDto));
    }

    @RequestMapping(method = GET, path = "/{uuid}")
    public ResponseEntity<CommentReadDto> findById(@PathVariable UUID uuid){
        return ResponseEntity.status(OK).body(service.findById(uuid));
    }

    @RequestMapping(method = GET)
    public ResponseEntity<Page<CommentReadDto>> findAllByCommentFilterPageable(@Valid CommentFilter filter, @PageableDefault Pageable pageable){
        return ResponseEntity.status(OK).body(service.findAllByCommentFilterPageable(filter, pageable ));
    }

    @RequestMapping(method = PUT, path = "/{uuid}")
    @SecurityRequirement(name = "api_key")
    public ResponseEntity<CommentReadDto> updateById(@PathVariable UUID uuid, @RequestBody CommentCreateDto createDto){
        return ResponseEntity.status(ACCEPTED).body(service.updateById(uuid, createDto));
    }

    @RequestMapping(method = DELETE, path = "/{uuid}")
    @SecurityRequirement(name = "api_key")
    public ResponseEntity<?> deleteById(@PathVariable UUID uuid){
        service.deleteById(uuid);
        return ResponseEntity.status(NO_CONTENT).build();
    }
}
