package com.sinacolada.tiki.util.custom.annotation.email;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Constraint(validatedBy = ACEmailValidator.class)
public @interface Email {

    String message() default "invalid email";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}