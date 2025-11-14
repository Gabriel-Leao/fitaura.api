package br.com.leao.gabriel.fitaura.api.domain.user.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String zipCode;
    private String street;
    private String neighborhood;
    private String city;
    private String number;
    private BrazilianUfs uf;
    private String complement;
}
