package br.com.leao.gabriel.fitaura.api.adapters.in.user.dto;

import br.com.leao.gabriel.fitaura.api.domain.user.model.Address;

import java.time.LocalDate;

public record UserResponse(
        long id,
        String name,
        String email,
        LocalDate birthDay,
        AddressResponse address
) {}
