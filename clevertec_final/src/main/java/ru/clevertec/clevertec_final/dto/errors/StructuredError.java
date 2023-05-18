package ru.clevertec.clevertec_final.dto.errors;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Set;


@Getter
@Builder
public class StructuredError {

    private final HttpStatus status;
    private final String uri;
    private final Set<ErrorMessage> errors;

}
