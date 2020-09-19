package com.consignment.validation;

import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author:Nguyen Anh Tuan
 * <p>
 * September 19,2020
 */
public class UsernameInputValidator implements ConstraintValidator<UsernamePattern,String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.isBlank(s)) {
            return false;
        }
        return s.matches("^[a-zA-Z0-9_]*$");
    }
}
