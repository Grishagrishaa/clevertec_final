package ru.clevertec.clevertec_final.controller.pagination.filter;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldNameConstants;

/**
 * DTO - filter for comments entities.
 */
@Data
@Builder
@FieldNameConstants
@AllArgsConstructor(staticName = "of")
public class CommentFilter {

    /**
     * The username to filter comments by.
     */
    @Size(min = 1, max = 20)
    private String username;

    /**
     * The text to filter comments by.
     */
    @Size(min = 1, max = 300)
    private String text;

    /**
     * Creates a new instance of CommentFilter with default values.
     *
     * @return A new instance of CommentFilter with default values.
     */
    public static CommentFilter defaultValues() {
        return CommentFilter.builder().build();
    }
}
