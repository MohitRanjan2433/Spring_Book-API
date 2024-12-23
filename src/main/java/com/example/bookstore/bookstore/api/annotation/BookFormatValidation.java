package com.example.bookstore.bookstore.api.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.awt.print.Book;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Constraint(validatedBy = {BookFormatValidator.class})
public @interface BookFormatValidation {

    String message() default "Book Format can only be PAPER or PDF";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
