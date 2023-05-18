package ru.clevertec.clevertec_final.testUtils.builder.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;
import ru.clevertec.clevertec_final.dto.request.CommentCreateDto;
import ru.clevertec.clevertec_final.dto.response.CommentReadDto;
import ru.clevertec.clevertec_final.repository.entity.Comment;
import ru.clevertec.clevertec_final.testUtils.builder.TestBuilder;

import java.time.Instant;
import java.util.UUID;

import static ru.clevertec.clevertec_final.testUtils.TestUtils.getRandomString;

@With
@Data
@AllArgsConstructor @NoArgsConstructor
public class CommentTestBuilder implements TestBuilder<Comment> {

    private UUID uuid;
    private Instant createdDate;
    private Instant updatedDate;
    private String text;
    private UUID newsUuid;
    private String username;
    private String modifiedBy;


    public static CommentTestBuilder defaultValues(){
        CommentTestBuilder commentTestBuilder = new CommentTestBuilder();

        commentTestBuilder.setUuid(UUID.fromString("96966e15-fc8f-4c53-9056-ccbf36a865f9"));
        commentTestBuilder.setCreatedDate(Instant.MAX);
        commentTestBuilder.setUpdatedDate(Instant.MAX);
        commentTestBuilder.setText("Comment text sample");
        commentTestBuilder.setNewsUuid(UUID.fromString("e6dd4609-89e6-4fc6-b4b3-bda2f3a90607"));
        commentTestBuilder.setUsername("BOSS");
        commentTestBuilder.setModifiedBy("BOSS");

        return commentTestBuilder;
    }

    public static CommentTestBuilder randomValues(){
        CommentTestBuilder commentTestBuilder = new CommentTestBuilder();

        commentTestBuilder.setUuid(UUID.randomUUID());
        commentTestBuilder.setCreatedDate(Instant.now());
        commentTestBuilder.setUpdatedDate(Instant.now());
        commentTestBuilder.setText(getRandomString());
        commentTestBuilder.setNewsUuid(UUID.randomUUID());
        commentTestBuilder.setUsername(getRandomString());
        commentTestBuilder.setModifiedBy(getRandomString());

        return commentTestBuilder;
    }

    public CommentCreateDto buildCreateDto(){

        return CommentCreateDto.builder()
                .setText(this.text)
                .setNewsUuid(this.newsUuid)
                .setUsername(this.username)
                .build();
    }

    public static CommentCreateDto toCreateDto(Comment comment){

        return CommentCreateDto.builder()
                .setText(comment.getText())
                .setNewsUuid(comment.getNewsUuid())
                .setUsername(comment.getUsername())
                .build();
    }

    public CommentReadDto buildReadDto(){

        return CommentReadDto.builder()
                .setUuid(this.uuid)
                .setCreatedDate(this.createdDate)
                .setText(this.text)
                .setNewsUuid(this.newsUuid)
                .setUsername(this.username)
                .setModifiedBy(this.modifiedBy)
                .build();
    }

    public static CommentReadDto toReadDto(Comment comment){

        return CommentReadDto.builder()
                .setUuid(comment.getUuid())
                .setCreatedDate(comment.getCreatedDate())
                .setText(comment.getText())
                .setNewsUuid(comment.getNewsUuid())
                .setUsername(comment.getUsername())
                .setModifiedBy(comment.getModifiedBy())
                .build();
    }

    @Override
    public Comment build() {
        return Comment.builder()
                .setUuid(this.uuid)
                .setCreatedDate(this.createdDate)
                .setUpdatedDate(this.updatedDate)
                .setModifiedBy(this.modifiedBy)
                .setText(this.text)
                .setNewsUuid(this.newsUuid)
                .setUsername(this.username)
                .build();
    }
}
