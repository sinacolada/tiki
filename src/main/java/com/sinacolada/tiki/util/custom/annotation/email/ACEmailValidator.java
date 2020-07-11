package com.sinacolada.tiki.util.custom.annotation.email;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ACEmailValidator implements ConstraintValidator<Email, String> {

    // private static final boolean ALLOW_LOCAL = false;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return false;
    }

}