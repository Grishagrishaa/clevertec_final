package ru.clevertec.userservice.unit.service.validators.impl;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.clevertec.userservice.dto.request.UserCreateDto;
import ru.clevertec.userservice.repository.entity.enums.ERole;
import ru.clevertec.userservice.testUtils.builder.impl.UserTestBuilder;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;



@ExtendWith(MockitoExtension.class)
class ValueOfEnumValidatorTest {
    private static Validator validator;

    @BeforeAll
    public static void setupValidatorInstance() {
        validator = Validation.buildDefaultValidatorFactory()
                .getValidator();
    }

    @Test
    public void validateShouldReturnExceptionIfIncorrectEnumName() {
        UserCreateDto createDto = UserTestBuilder.defaultValues().buildCreateDto();
        createDto.setRole("INCORRECT_ROLE_NAME");

        Set<ConstraintViolation<UserCreateDto>> violations = validator.validate(createDto);

        assertThat(violations).isNotEmpty();
    }

    @Test
    public void validateShouldReturnExceptionIfEnumNameNull() {
        UserCreateDto createDto = UserTestBuilder.defaultValues().buildCreateDto();
        createDto.setRole(null);

        Set<ConstraintViolation<UserCreateDto>> violations = validator.validate(createDto);

        assertThat(violations).isNotEmpty();
    }

    @Test
    public void validateShouldReturnExceptionIfEnumNameBlank() {
        UserCreateDto createDto = UserTestBuilder.defaultValues().buildCreateDto();
        createDto.setRole("");

        Set<ConstraintViolation<UserCreateDto>> violations = validator.validate(createDto);

        assertThat(violations).isNotEmpty();
    }

    @Test
    public void validateShouldNotReturnExceptionIfCorrectEnumName() {
        UserCreateDto createDto = UserTestBuilder.defaultValues().buildCreateDto();
        Set<ConstraintViolation<UserCreateDto>> violations = validator.validate(createDto);

        assertThat(violations).isEmpty();
    }
}