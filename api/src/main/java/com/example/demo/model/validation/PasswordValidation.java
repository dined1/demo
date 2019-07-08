package com.example.demo.model.validation;

import com.example.demo.model.SystemUserDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

public class PasswordValidation implements ConstraintValidator<CheckPassword, SystemUserDto> {

    @Override
    public void initialize(CheckPassword constraintAnnotation) {
        // nothing to initialize
    }

    @Override
    public boolean isValid(SystemUserDto user, ConstraintValidatorContext context) {
        return Objects.equals(user.getPassword(), user.getPasswordConfirm());
    }
}
