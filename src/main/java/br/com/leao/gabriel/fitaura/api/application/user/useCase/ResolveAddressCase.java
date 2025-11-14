package br.com.leao.gabriel.fitaura.api.application.user.useCase;

import br.com.leao.gabriel.fitaura.api.domain.user.model.Address;

public interface ResolveAddressCase {
    Address execute(String cep, String number);
}
