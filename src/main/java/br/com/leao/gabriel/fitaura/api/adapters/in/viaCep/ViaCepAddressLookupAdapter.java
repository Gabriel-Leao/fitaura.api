package br.com.leao.gabriel.fitaura.api.adapters.in.viaCep;

import br.com.leao.gabriel.fitaura.api.domain.user.model.Address;
import br.com.leao.gabriel.fitaura.api.domain.user.model.BrazilianUfs;
import br.com.leao.gabriel.fitaura.api.domain.user.port.out.AddressLookupPort;
import br.com.leao.gabriel.fitaura.api.shared.exceptions.NotFoundException;
import br.com.leao.gabriel.fitaura.api.shared.exceptions.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ViaCepAddressLookupAdapter implements AddressLookupPort {
    private final ViaCepClient viaCepClient;

    @Override
    public Address lookupByCep(String cep, String number) {

        ViaCepResponse response = viaCepClient.getCep(cep);

        if (response == null)
            throw new NotFoundException("Zip code service is down");

        if (response.cep() == null)
            throw new NotFoundException("Zip code not found");

        if (response.logradouro() == null || response.bairro() == null)
            throw new BadRequestException("Zip code incomplete or incorrect");

        return Address.builder()
                .zipCode(response.cep())
                .street(response.logradouro())
                .neighborhood(response.bairro())
                .city(response.localidade())
                .number(number)
                .uf(BrazilianUfs.valueOf(response.uf()))
                .complement(response.complemento())
                .build();
    }
}
