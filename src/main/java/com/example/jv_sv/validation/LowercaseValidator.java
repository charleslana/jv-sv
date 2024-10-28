package com.example.jv_sv.validation;

import com.example.jv_sv.annotation.Lowercase;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class LowercaseValidator implements ConstraintValidator<Lowercase, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value == null || value.equals(value.toLowerCase());
    }
}
