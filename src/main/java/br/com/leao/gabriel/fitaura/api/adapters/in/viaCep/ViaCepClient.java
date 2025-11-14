package br.com.leao.gabriel.fitaura.api.adapters.in.viaCep;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class ViaCepClient {
    private final RestTemplate restTemplate;

    public ViaCepResponse getCep(String cep) {
        try {
            String url = "https://viacep.com.br/ws/" + cep + "/json/";
            return restTemplate.getForObject(url, ViaCepResponse.class);
        } catch (RestClientException e) {
            return null;
        }
    }
}
