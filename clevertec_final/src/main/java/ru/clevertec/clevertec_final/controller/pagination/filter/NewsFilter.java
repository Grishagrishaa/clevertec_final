package ru.clevertec.clevertec_final.controller.pagination.filter;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldNameConstants;

/**
 * DTO-filter for news.
 */
@Data
@Builder
@FieldNameConstants
@AllArgsConstructor(staticName = "of")
public class NewsFilter {

    /**
     * The title to filter news by.
     */
    @Size(min = 1, max = 20)
    private String title;

    /**
     * The text to filter news by.
     */
    @Size(min = 1, max = 300)
    private String text;

    /**
     * Creates a new instance of NewsFilter with default values.
     *
     * @return A new instance of NewsFilter with default values.
     */
    public static NewsFilter defaultValues() {
        return NewsFilter.builder().build();
    }
}
