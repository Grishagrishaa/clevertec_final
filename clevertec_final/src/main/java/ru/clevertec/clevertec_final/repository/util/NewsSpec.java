package ru.clevertec.clevertec_final.repository.util;

import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;
import ru.clevertec.clevertec_final.repository.entity.News;

/**
 * Utility class for creating specifications for News entity.
 */
@UtilityClass
public class NewsSpec {

    /**
     * Creates a specification for performing a "like" query on a specific field of the Comment entity.
     *
     * @param fieldName  the name of the field to perform the "like" query on
     * @param fieldValue the value to search for (can be null)
     * @return a specification for the "like" query
     */
    public static Specification<News> like(String fieldName, String fieldValue){
        return (root, query, criteriaBuilder)
                -> {
            if(fieldValue == null){
                return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
            }

            return criteriaBuilder.like(root.get(fieldName), "%"+fieldValue+"%");
        };
    }

}
