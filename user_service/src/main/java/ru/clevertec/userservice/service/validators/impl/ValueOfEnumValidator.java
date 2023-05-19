package ru.clevertec.userservice.service.validators.impl;

import ru.clevertec.userservice.service.validators.api.ValueOfEnum;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The {@code ValueOfEnumValidator} class is a validator implementation used by the {@code @ValueOfEnum} annotation
 * to validate if a value belongs to the defined values of a specific enum class.
 *
 * @param <T> the type of the enum class
 */
public class ValueOfEnumValidator implements ConstraintValidator<ValueOfEnum, CharSequence> {

    private List<String> acceptedValues;

    /**
     * Initializes the validator by retrieving the accepted values from the enum class specified in the {@code @ValueOfEnum} annotation.
     *
     * @param annotation the {@code ValueOfEnum} annotation instance
     */
    @Override
    public void initialize(ValueOfEnum annotation) {
        acceptedValues = Stream.of(annotation.enumClass().getEnumConstants())
                .map(Enum::name)
                .collect(Collectors.toList());
    }

    /**
     * Validates if the given value is one of the accepted values.
     *
     * @param value   the value to be validated
     * @param context the validator context
     * @return {@code true} if the value is valid, {@code false} otherwise
     */
    @Override
    public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
        if(value == null || value.length() == 0) {
            return false;
        }

        return acceptedValues.contains(value.toString());
    }

}
