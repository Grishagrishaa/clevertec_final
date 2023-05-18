package ru.clevertec.userservice.dto.errors;

import java.util.Set;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
@Builder
public class StructuredError {

    private final HttpStatus status;
    private final String uri;
    private final Set<ErrorMessage> errors;

}
