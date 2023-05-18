package ru.clevertec.clevertec_final.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import ru.clevertec.clevertec_final.repository.entity.Comment;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Data
@Builder(setterPrefix = "set")
@RequiredArgsConstructor
@AllArgsConstructor
public class NewsWithCommentsReadDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 40L;

    private UUID uuid;
    private Instant createdDate;
    private String title;
    private String text;
    private String username;
    private String modifiedBy;
    private List<CommentReadDto> comments;

}
