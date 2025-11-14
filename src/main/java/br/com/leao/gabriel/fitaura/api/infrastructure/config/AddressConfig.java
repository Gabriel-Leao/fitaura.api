package br.com.leao.gabriel.fitaura.api.infrastructure.config;

import br.com.leao.gabriel.fitaura.api.adapters.in.viaCep.ViaCepAddressLookupAdapter;
import br.com.leao.gabriel.fitaura.api.application.user.service.ResolveAddressService;
import br.com.leao.gabriel.fitaura.api.application.user.useCase.ResolveAddressCase;
import br.com.leao.gabriel.fitaura.api.domain.user.port.out.AddressLookupPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AddressConfig {
    @Bean
    public AddressLookupPort addressLookupPort(ViaCepAddressLookupAdapter adapter) {
        return adapter;
    }

    @Bean
    public ResolveAddressCase resolveAddressCase(AddressLookupPort addressLookupPort) {
        return new ResolveAddressService(addressLookupPort);
    }
}
