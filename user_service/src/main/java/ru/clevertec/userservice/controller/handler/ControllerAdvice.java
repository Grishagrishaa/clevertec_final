package ru.clevertec.userservice.controller.handler;


import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import ru.clevertec.userservice.dto.errors.ErrorMessage;
import ru.clevertec.userservice.dto.errors.StructuredError;
import jakarta.persistence.OptimisticLockException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.postgresql.util.PSQLException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Set;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toSet;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestControllerAdvice
public class ControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorMessage> handle(IllegalArgumentException e, HttpServletRequest req){
        return ResponseEntity.badRequest().body(ErrorMessage.builder()
                .message(e.getMessage())
                .status(BAD_REQUEST)
                .uri(req.getRequestURI())
                .build());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorMessage> handle(EntityNotFoundException e, HttpServletRequest req){
        return ResponseEntity.status(NO_CONTENT).body(ErrorMessage.builder()
                .message("NO CONTENT FOUND")
                .status(NO_CONTENT)
                .uri(req.getRequestURI())
                .build());
    }

    @ExceptionHandler(OptimisticLockException.class)
    public ResponseEntity<ErrorMessage> handle(OptimisticLockException e, HttpServletRequest req){
        return ResponseEntity.status(CONFLICT).body(ErrorMessage.builder()
                .message(e.getMessage())
                .status(CONFLICT)
                .uri(req.getRequestURI())
                .build());
    }

    @ExceptionHandler(PSQLException.class)
    public ResponseEntity<ErrorMessage> handle(PSQLException e, HttpServletRequest req){
        return ResponseEntity.badRequest().body(ErrorMessage.builder()
                .message(e.getServerErrorMessage().getDetail())
                .status(BAD_REQUEST)
                .uri(req.getRequestURI())
                .build());
}

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<StructuredError> handle(ConstraintViolationException e, HttpServletRequest req){
        return ResponseEntity.badRequest().body(StructuredError.builder()
                .errors(buildErrorMessages(e.getConstraintViolations()))
                .status(BAD_REQUEST)
                .uri(req.getRequestURI())
                .build());
    }

    private Set<ErrorMessage> buildErrorMessages(Set<ConstraintViolation<?>> violations) {
        return violations.stream()
                .map(violation -> ErrorMessage.builder()
                        .uri(StreamSupport.stream(violation.getPropertyPath().spliterator(), false)
                                .reduce((first, second) -> second)
                                .orElse(null)
                                .toString())
                        .message(violation.getMessage())
                        .build())
                .collect(toSet());
    }
}

