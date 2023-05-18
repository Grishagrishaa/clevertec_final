package ru.clevertec.clevertec_final.service.impl;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.clevertec.clevertec_final.controller.pagination.filter.CommentFilter;
import ru.clevertec.clevertec_final.controller.pagination.filter.NewsFilter;
import ru.clevertec.clevertec_final.dto.request.CommentCreateDto;
import ru.clevertec.clevertec_final.dto.response.CommentReadDto;
import ru.clevertec.clevertec_final.repository.api.CommentRepository;
import ru.clevertec.clevertec_final.repository.entity.Comment;
import ru.clevertec.clevertec_final.repository.util.CommentSpec;
import ru.clevertec.clevertec_final.service.CommentService;
import ru.clevertec.clevertec_final.service.mapper.CommentMapper;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentServiceImpl implements CommentService {

    private final CommentRepository repository;
    private final CommentMapper mapper;

    @Override
    @Transactional
    @CachePut(cacheNames = "commentReadDto")
    public CommentReadDto create(CommentCreateDto createDto) {
        Comment entityToCreate = mapper.createDtoToEntity(createDto);
        return mapper.entityToReadDto(repository.save(entityToCreate));
    }

    @Override
    @Cacheable(cacheNames = "commentReadDto")
    public CommentReadDto findById(UUID uuid) {
        Comment comment = repository.findById(uuid).orElseThrow(EntityNotFoundException::new);
        return mapper.entityToReadDto(comment);
    }

    @Override
    public Page<CommentReadDto> findAllByCommentFilterPageable(CommentFilter filter, Pageable pageable) {
        Specification<Comment> spec = Specification.where(CommentSpec.like(CommentFilter.Fields.username, filter.getUsername())
                                                  .and(CommentSpec.like(NewsFilter.Fields.text, filter.getText())));

        Page<Comment> newsPage = repository.findAll(spec, pageable);

        return newsPage.map(mapper::entityToReadDto);

    }

    @Override
    @Transactional
    @CachePut(cacheNames = "commentReadDto")
    @PostAuthorize("hasAuthority('ADMIN') || returnObject.username.equals(principal.username)")
    public CommentReadDto updateById(UUID uuid, CommentCreateDto updateDto) {
        Comment comment = repository.getReferenceById(uuid);

        mapper.update(comment, updateDto);

        return mapper.entityToReadDto(repository.save(comment));
    }

    @Override
    @Transactional
    @CacheEvict(cacheNames = "commentReadDto")
    @PreAuthorize("hasAuthority('ADMIN') || @commentServiceImpl.findById(#uuid).username.equals(principal.username)")
    public void deleteById(UUID uuid) {
        repository.findById(uuid).ifPresentOrElse(repository::delete, () -> { throw new EntityNotFoundException(); });
    }

}
