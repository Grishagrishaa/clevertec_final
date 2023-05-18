package ru.clevertec.clevertec_final.testUtils.builder.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;
import ru.clevertec.clevertec_final.dto.request.CommentCreateDto;
import ru.clevertec.clevertec_final.dto.request.NewsCreateDto;
import ru.clevertec.clevertec_final.dto.response.CommentReadDto;
import ru.clevertec.clevertec_final.dto.response.NewsReadDto;
import ru.clevertec.clevertec_final.dto.response.NewsWithCommentsReadDto;
import ru.clevertec.clevertec_final.repository.entity.Comment;
import ru.clevertec.clevertec_final.repository.entity.News;
import ru.clevertec.clevertec_final.testUtils.builder.TestBuilder;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import static ru.clevertec.clevertec_final.testUtils.TestUtils.getRandomString;

@With
@Data
@AllArgsConstructor @NoArgsConstructor
public class NewsTestBuilder implements TestBuilder<News> {

    private UUID uuid;
    private Instant createdDate;
    private Instant updatedDate;
    private String title;
    private String text;
    private String username;
    private String modifiedBy;
    private List<Comment> comments;


    public static NewsTestBuilder defaultValues(){
        NewsTestBuilder commentTestBuilder = new NewsTestBuilder();

        commentTestBuilder.setUuid(UUID.fromString("96966e15-fc8f-4c53-9056-ccbf36a865f9"));
        commentTestBuilder.setCreatedDate(Instant.MAX);
        commentTestBuilder.setUpdatedDate(Instant.MAX);
        commentTestBuilder.setTitle("Title sample");
        commentTestBuilder.setText("Comment text sample");
        commentTestBuilder.setUsername("BOSS");
        commentTestBuilder.setModifiedBy("BOSS");
        commentTestBuilder.setComments(List.of(CommentTestBuilder.defaultValues().build()));

        return commentTestBuilder;
    }

    public static NewsTestBuilder randomValues(){
        NewsTestBuilder commentTestBuilder = new NewsTestBuilder();

        commentTestBuilder.setUuid(UUID.randomUUID());
        commentTestBuilder.setCreatedDate(Instant.now());
        commentTestBuilder.setUpdatedDate(Instant.now());
        commentTestBuilder.setTitle(getRandomString());
        commentTestBuilder.setText(getRandomString());
        commentTestBuilder.setUsername(getRandomString());
        commentTestBuilder.setModifiedBy(getRandomString());
        commentTestBuilder.setComments(List.of(CommentTestBuilder.randomValues().build()));

        return commentTestBuilder;
    }

    public NewsCreateDto buildCreateDto(){
        return NewsCreateDto.builder()
                .setTitle(this.title)
                .setText(this.text)
                .build();
    }

    public static NewsCreateDto toCreateDto(News news){
        return NewsCreateDto.builder()
                .setTitle(news.getTitle())
                .setText(news.getText())
                .build();
    }

    public NewsReadDto buildReadDto(){
        return NewsReadDto.builder()
                .setUuid(this.uuid)
                .setCreatedDate(this.createdDate)
                .setTitle(this.title)
                .setText(this.text)
                .setUsername(this.username)
                .setModifiedBy(this.modifiedBy)
                .build();
    }

    public static NewsReadDto toReadDto(News news){
        return NewsReadDto.builder()
                .setUuid(news.getUuid())
                .setCreatedDate(news.getCreatedDate())
                .setTitle(news.getTitle())
                .setText(news.getText())
                .setUsername(news.getUsername())
                .setModifiedBy(news.getModifiedBy())
                .build();
    }

    public NewsWithCommentsReadDto buildReadDtoWithTags(){
        return NewsWithCommentsReadDto.builder()
                .setUuid(this.uuid)
                .setCreatedDate(this.createdDate)
                .setTitle(this.title)
                .setText(this.text)
                .setUsername(this.username)
                .setModifiedBy(this.modifiedBy)
                .build();
    }

    @Override
    public News build() {
        return News.builder()
                .setUuid(this.uuid)
                .setCreatedDate(this.createdDate)
                .setUpdatedDate(this.updatedDate)
                .setTitle(this.title)
                .setText(this.text)
                .setUsername(this.username)
                .setModifiedBy(this.modifiedBy)
                .setComments(this.comments)
                .build();
    }
}
