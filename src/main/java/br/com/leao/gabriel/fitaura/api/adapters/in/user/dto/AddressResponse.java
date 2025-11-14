package br.com.leao.gabriel.fitaura.api.adapters.in.user.dto;

public record AddressResponse(
        String cep,
        String number,
        String street,
        String neighborhood,
        String city,
        String uf,
        String complement
) {}
