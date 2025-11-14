package br.com.leao.gabriel.fitaura.api.domain.user.port.out;

import br.com.leao.gabriel.fitaura.api.domain.user.model.Address;

public interface AddressLookupPort {
    Address lookupByCep(String cep, String number);
}
