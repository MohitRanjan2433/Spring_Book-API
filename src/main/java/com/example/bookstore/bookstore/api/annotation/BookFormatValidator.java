package com.example.bookstore.bookstore.api.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class BookFormatValidator implements ConstraintValidator<BookFormatValidation, String> {

    @Override
    public boolean isValid(String inputFormat, ConstraintValidatorContext constraintValidatorContext) {
        if(inputFormat == null) return false;
        List<String> format = List.of("PAPER", "PDF");
        return format.contains(inputFormat);
    }
}
