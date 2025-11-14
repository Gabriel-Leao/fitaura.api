package br.com.leao.gabriel.fitaura.api.application.user.service;

import br.com.leao.gabriel.fitaura.api.application.user.useCase.ResolveAddressCase;
import br.com.leao.gabriel.fitaura.api.domain.user.model.Address;
import br.com.leao.gabriel.fitaura.api.domain.user.port.out.AddressLookupPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ResolveAddressService implements ResolveAddressCase {

    private final AddressLookupPort addressLookupPort;

    @Override
    public Address execute(String cep, String number) {
        return addressLookupPort.lookupByCep(cep, number);
    }
}
