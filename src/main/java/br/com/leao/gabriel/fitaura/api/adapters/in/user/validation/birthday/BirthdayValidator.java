package br.com.leao.gabriel.fitaura.api.adapters.in.user.validation.birthday;

import br.com.leao.gabriel.fitaura.api.shared.utils.DateFormatterUtil;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;

public class BirthdayValidator implements ConstraintValidator<ValidateBirthday, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isBlank()) {
            return false;
        }

        try {
            LocalDate birthdate = LocalDate.parse(value, DateFormatterUtil.dateFormatter);

            if (birthdate.isAfter(LocalDate.now())) {
                return false;
            }

            int age = Period.between(birthdate, LocalDate.now()).getYears();

            return age >= 18;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
