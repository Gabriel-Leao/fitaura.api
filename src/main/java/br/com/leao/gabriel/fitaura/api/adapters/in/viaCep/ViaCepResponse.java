package br.com.leao.gabriel.fitaura.api.adapters.in.viaCep;

public record ViaCepResponse(
        String cep,
        String logradouro,
        String complemento,
        String bairro,
        String localidade,
        String uf,
        Boolean erro
) {}
