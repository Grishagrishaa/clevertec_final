package ru.clevertec.clevertec_final.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import ru.clevertec.clevertec_final.repository.entity.News;

import java.util.UUID;

@Data
@Builder(setterPrefix = "set")
@RequiredArgsConstructor @AllArgsConstructor
public class CommentCreateDto {

    @NotBlank
    @Size(min = 5, max = 25)
    private String text;
    @NotBlank
    @Size(min = 2, max = 25)
    private String username;
    @NotBlank
    private UUID newsUuid;

}
