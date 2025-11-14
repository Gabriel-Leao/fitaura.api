package br.com.leao.gabriel.fitaura.api.shared.mappers;

import br.com.leao.gabriel.fitaura.api.adapters.in.user.dto.UpsertUserRequest;
import br.com.leao.gabriel.fitaura.api.adapters.in.user.dto.UserResponse;
import br.com.leao.gabriel.fitaura.api.adapters.out.user.persistence.UserEntity;
import br.com.leao.gabriel.fitaura.api.domain.user.model.Address;
import br.com.leao.gabriel.fitaura.api.domain.user.model.Role;
import br.com.leao.gabriel.fitaura.api.domain.user.model.User;
import br.com.leao.gabriel.fitaura.api.shared.utils.DateFormatterUtil;
import br.com.leao.gabriel.fitaura.api.shared.utils.EnumConverter;

public class UserMapper {
    public static User toDomain(UpsertUserRequest dto) {

        User user = new User();
        user.setName(dto.name());
        user.setEmail(dto.email());
        user.setPassword(dto.password());
        user.setBirthday(DateFormatterUtil.transformStringToLocalDate(dto.birthday()));
        user.setRole(EnumConverter.toEnumOrDefault(dto.role(), Role.class, Role.USER));


        Address address = new Address();
        address.setZipCode(dto.zipCode());
        address.setNumber(dto.number());

        user.setAddress(address);

        return user;
    }


    public static UserResponse toResponse(User user) {
        if (user == null) return null;

        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getBirthday(),
                AddressMapper.toResponse(user.getAddress())
        );
    }


    public static UserEntity toEntity(User user) {
        if (user == null) return null;

        return UserEntity.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .birthday(user.getBirthday())
                .role(user.getRole())
                .address(AddressMapper.toEntity(user.getAddress()))
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();
    }


    public static User toDomain(UserEntity entity) {
        if (entity == null) return null;

        User user = new User();
        user.setId(entity.getId());
        user.setName(entity.getName());
        user.setEmail(entity.getEmail());
        user.setPassword(entity.getPassword());
        user.setBirthday(entity.getBirthday());
        user.setRole(entity.getRole());
        user.setCreatedAt(entity.getCreatedAt());
        user.setUpdatedAt(entity.getUpdatedAt());

        user.setAddress(AddressMapper.toDomain(entity.getAddress()));

        return user;
    }
}
