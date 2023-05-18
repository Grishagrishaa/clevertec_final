package ru.clevertec.clevertec_final.controller.pagination.filter;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldNameConstants;

@Data
@Builder
@FieldNameConstants
@AllArgsConstructor(staticName = "of")
public class CommentFilter {

    @Size(min = 1, max = 20)
    private String username;
    @Size(min = 1, max = 300)
    private String text;

    public static CommentFilter defaultValues(){
        return CommentFilter.builder().build();
    }
}
