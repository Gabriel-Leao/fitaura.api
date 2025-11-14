package br.com.leao.gabriel.fitaura.api.adapters.out.user.persistence;

import br.com.leao.gabriel.fitaura.api.domain.user.model.BrazilianUfs;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class AddressEntity {
    @Column(nullable = false)
    private String city;

    @Column()
    private String complement;

    @Column(nullable = false)
    private String neighborhood;

    @Column(nullable = false)
    private String number;

    @Column(nullable = false, name = "zip_code")
    private String zipCode;

    @Enumerated(EnumType.STRING)
    private BrazilianUfs uf;

    @Column(nullable = false)
    private String street;
}
