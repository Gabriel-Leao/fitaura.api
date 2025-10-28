package br.com.leao.gabriel.fitaura.api.adapters.in.user.validation.birthday;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = BirthdayValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidateBirthday {
    String message() default "Invalid birthdate format. Expected format: dd/MM/yyyy and must be 18 years or older.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
