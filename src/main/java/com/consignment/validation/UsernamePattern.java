package com.consignment.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author:Nguyen Anh Tuan
 * <p>
 * September 19,2020
 */
@Documented
@Constraint(validatedBy = UsernameInputValidator.class)
@Retention(RUNTIME)
public @interface UsernamePattern {
    String message() default "{Username không phù hợp}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
