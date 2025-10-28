package br.com.leao.gabriel.fitaura.api.adapters.in.user.dto;

import java.time.LocalDate;

public record UserResponse(
        long id,
        String name,
        String email,
        LocalDate birthDay
) {}
