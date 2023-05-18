package ru.clevertec.clevertec_final.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ru.clevertec.clevertec_final.dto.request.NewsCreateDto;
import ru.clevertec.clevertec_final.dto.response.NewsReadDto;
import ru.clevertec.clevertec_final.dto.response.NewsWithCommentsReadDto;
import ru.clevertec.clevertec_final.repository.entity.Comment;
import ru.clevertec.clevertec_final.repository.entity.News;

import java.util.List;

@Mapper(uses = CommentMapper.class,
        componentModel = MappingConstants.ComponentModel.SPRING,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface NewsMapper {

    @Mapping(target = "comments", ignore = true)
    News createDtoToEntity(NewsCreateDto createDto);

    NewsReadDto entityToReadDto(News news);

    @Mapping(source = "commentList", target = "comments")
    NewsWithCommentsReadDto entityToReadDtoWithComments(News news, List<Comment> commentList);


    @Mapping(target = "comments", ignore = true)
    void update(@MappingTarget News entity, NewsCreateDto createDto);
}
