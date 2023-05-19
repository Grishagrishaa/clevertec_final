package ru.clevertec.userservice.service.validators.api;


import ru.clevertec.userservice.service.validators.impl.ValueOfEnumValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * The {@code ValueOfEnum} annotation is used to validate if a value belongs to the defined values of a specific enum class.
 * It should be applied to fields, method parameters, and method return types that need to be validated.
 */
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = ValueOfEnumValidator.class)
public @interface ValueOfEnum {

    /**
     * Specifies the enum class to which the value should belong.
     *
     * @return the enum class
     */
    Class<? extends Enum<?>> enumClass();

    /**
     * Specifies the error message template to be used when the value fails the validation.
     * The default message template includes the placeholder {enumClass.values()} which will be replaced
     * with the string representation of the enum values from the specified enum class.
     *
     * @return the error message template
     */
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
