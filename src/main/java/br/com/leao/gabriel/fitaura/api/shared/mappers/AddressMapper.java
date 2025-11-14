package br.com.leao.gabriel.fitaura.api.shared.mappers;

import br.com.leao.gabriel.fitaura.api.adapters.in.user.dto.AddressResponse;
import br.com.leao.gabriel.fitaura.api.adapters.out.user.persistence.AddressEntity;
import br.com.leao.gabriel.fitaura.api.domain.user.model.Address;

public class AddressMapper {
    public static AddressResponse toResponse(Address address) {
        if (address == null) return null;

        return new AddressResponse(
                address.getZipCode(),
                address.getNumber(),
                address.getStreet(),
                address.getNeighborhood(),
                address.getCity(),
                address.getUf().name(),
                address.getComplement()
        );
    }

    public static AddressEntity toEntity(Address address) {
        if (address == null) return null;

        return AddressEntity.builder()
                .zipCode(address.getZipCode())
                .number(address.getNumber())
                .street(address.getStreet())
                .neighborhood(address.getNeighborhood())
                .city(address.getCity())
                .uf(address.getUf())
                .complement(address.getComplement())
                .build();
    }

    public static Address toDomain(AddressEntity entity) {
        if (entity == null) return null;

        return Address.builder()
                .zipCode(entity.getZipCode())
                .number(entity.getNumber())
                .street(entity.getStreet())
                .neighborhood(entity.getNeighborhood())
                .city(entity.getCity())
                .uf(entity.getUf())
                .complement(entity.getComplement())
                .build();
    }
}

