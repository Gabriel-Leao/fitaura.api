package br.com.leao.gabriel.fitaura.api.adapters.in.user.dto;

import br.com.leao.gabriel.fitaura.api.adapters.in.user.validation.birthday.ValidateBirthday;
import br.com.leao.gabriel.fitaura.api.adapters.in.validation.enums.ValidateEnum;
import br.com.leao.gabriel.fitaura.api.domain.user.model.Role;
import jakarta.validation.constraints.*;

public record UpsertUserRequest (
        @NotNull(message = "Name is required")
        @NotBlank(message = "Name can't be empty")
        @Size(min = 3, max = 150, message = "name must have between 3 and 150 characters")
        String name,

        @NotNull(message = "Email is required")
        @NotBlank(message = "Email can't be empty")
        @Email(message = "Invalid e-mail")
        @Size(max = 200, message = "Email should have at most 200 characters")
        String email,

        @NotNull(message = "Password is required")
        @NotBlank(message = "Password can't be empty")
        @Size(max = 72, min = 8, message = "Password must have a length between 8 and 72 characters")
        String password,

        @NotNull(message = "Birthday is required")
        @NotBlank(message = "Birthday can't be empty")
        @ValidateBirthday
        String birthday,

        @NotBlank(message = "Role can't be empty")
        @ValidateEnum(enumClass = Role.class, message = "Invalid role value")
        String role,

        @NotNull(message = "zipCode is required")
        @NotBlank(message = "zipCode can't be empty")
        @Pattern(regexp = "\\d{8}", message = "Zip code must have 8 numbers")
        String zipCode,

        @NotNull(message = "Number is required")
        @NotBlank(message = "Number can't be empty")
        String number
) {}
