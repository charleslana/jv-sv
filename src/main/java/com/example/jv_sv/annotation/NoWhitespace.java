package com.example.jv_sv.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.example.jv_sv.validation.NoWhitespaceValidator;

@Constraint(validatedBy = NoWhitespaceValidator.class)
@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface NoWhitespace {
    String message() default "Não deve estar vazio ou conter apenas espaços em branco";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
