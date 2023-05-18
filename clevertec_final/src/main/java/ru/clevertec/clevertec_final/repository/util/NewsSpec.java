package ru.clevertec.clevertec_final.repository.util;

import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;
import ru.clevertec.clevertec_final.repository.entity.News;

@UtilityClass
public class NewsSpec {

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
