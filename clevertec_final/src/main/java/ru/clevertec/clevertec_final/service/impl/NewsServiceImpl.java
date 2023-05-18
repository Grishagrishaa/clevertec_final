package ru.clevertec.clevertec_final.service.impl;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
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
import ru.clevertec.clevertec_final.controller.pagination.filter.NewsFilter;
import ru.clevertec.clevertec_final.dto.request.NewsCreateDto;
import ru.clevertec.clevertec_final.dto.response.NewsReadDto;
import ru.clevertec.clevertec_final.dto.response.NewsWithCommentsReadDto;
import ru.clevertec.clevertec_final.repository.api.CommentRepository;
import ru.clevertec.clevertec_final.repository.api.NewsRepository;
import ru.clevertec.clevertec_final.repository.entity.Comment;
import ru.clevertec.clevertec_final.repository.entity.News;
import ru.clevertec.clevertec_final.repository.util.NewsSpec;
import ru.clevertec.clevertec_final.service.NewsService;
import ru.clevertec.clevertec_final.service.mapper.NewsMapper;

import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class NewsServiceImpl implements NewsService {

    private final NewsRepository newsRepository;
    private final CommentRepository commentRepository;
    private final NewsMapper mapper;

    @Override
    @Transactional
    @CachePut(cacheNames = "newsReadDto")
    public NewsReadDto create(@Valid NewsCreateDto createDto) {

        News entityToCreate = mapper.createDtoToEntity(createDto);
        return mapper.entityToReadDto(newsRepository.save(entityToCreate));

    }

    @Override
    @Cacheable(cacheNames = "newsReadDto")
    public NewsReadDto findById(UUID uuid) {
        News news = newsRepository.findById(uuid)
                .orElseThrow(EntityNotFoundException::new);
        return mapper.entityToReadDto(news);
    }

    @Override
    public NewsWithCommentsReadDto findByIdWithCommentsPageable(UUID uuid, Pageable pageable) {
        News news = newsRepository.findById(uuid)
                .orElseThrow(EntityNotFoundException::new);
        List<Comment> comments = commentRepository.findAllByNewsUuid(uuid, pageable);

        return mapper.entityToReadDtoWithComments(news, comments);
    }

    @Override
    public Page<NewsReadDto> findAllByNewsFilterPageable(NewsFilter filter, Pageable pageable) {
        Specification<News> spec = Specification.where(NewsSpec.like(NewsFilter.Fields.title, filter.getTitle())
                                                .and(NewsSpec.like(NewsFilter.Fields.text, filter.getText())));

        Page<News> newsPage = newsRepository.findAll(spec, pageable);

        return newsPage.map(mapper::entityToReadDto);
    }

    @Override
    @Transactional
    @CachePut(cacheNames = "newsReadDto")
    @PostAuthorize("hasAuthority('ADMIN') || returnObject.username.equals(principal.username)")
    public NewsReadDto updateById(UUID uuid, @Valid NewsCreateDto updateDto) {
        News news = newsRepository.getReferenceById(uuid);
        mapper.update(news, updateDto);

        return mapper.entityToReadDto(newsRepository.save(news));
    }

    @Override
    @Transactional
    @CacheEvict(cacheNames = "newsReadDto")
    @PreAuthorize("hasAuthority('ADMIN') || @newsServiceImpl.findById(#uuid).username.equals(principal.username)")
    public void deleteById(UUID uuid) {
        newsRepository.findById(uuid).ifPresentOrElse(newsRepository::delete, () -> { throw new EntityNotFoundException(); });
    }

}
