package com.tickettracker.tickettrackerb.validators;

import java.util.EnumSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;



public class EnumValidator implements ConstraintValidator<ValidateEnum, String> {
    private Set<String> allowedValues;

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void initialize(ValidateEnum targetEnum) {
        Class<? extends Enum> enumSelected = targetEnum.targetClassType();
        allowedValues = (Set<String>) EnumSet.allOf(enumSelected).stream().map(e -> ((Enum<? extends Enum<?>>) e).name())
                .collect(Collectors.toSet());
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value == null || allowedValues.contains(value)? true : false; 
    }
}
