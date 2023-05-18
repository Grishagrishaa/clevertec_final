package ru.clevertec.clevertec_final.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@Builder(setterPrefix = "set")
@RequiredArgsConstructor @AllArgsConstructor
public class NewsCreateDto {

    @NotBlank
    @Size(min = 1, max = 25)
    private String title;
    @NotBlank
    @Size(min = 5, max = 150)
    private String text;

}
