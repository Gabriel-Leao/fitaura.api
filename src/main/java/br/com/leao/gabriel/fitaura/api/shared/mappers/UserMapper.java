package br.com.leao.gabriel.fitaura.api.shared.mappers;

import br.com.leao.gabriel.fitaura.api.adapters.in.user.dto.UpsertUserRequest;
import br.com.leao.gabriel.fitaura.api.adapters.in.user.dto.UserResponse;
import br.com.leao.gabriel.fitaura.api.adapters.out.user.persistence.UserEntity;
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
        return user;
    }

    public static UserResponse toResponse(User user) {
        return new UserResponse(user.getId(), user.getName(), user.getEmail(), user.getBirthday());
    }

    public static UserEntity toEntity(User user) {
        UserEntity entity = new UserEntity();
        entity.setId(user.getId());
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPassword(user.getPassword());
        entity.setBirthday(user.getBirthday());
        entity.setRole(user.getRole());
        entity.setCreatedAt(user.getCreatedAt());
        entity.setUpdatedAt(user.getUpdatedAt());
        return entity;
    }

    public static User toDomain(UserEntity entity) {
        User user = new User();
        user.setId(entity.getId());
        user.setName(entity.getName());
        user.setEmail(entity.getEmail());
        user.setPassword(entity.getPassword());
        user.setBirthday(entity.getBirthday());
        user.setRole(entity.getRole());
        user.setCreatedAt(entity.getCreatedAt());
        user.setUpdatedAt(entity.getUpdatedAt());
        return user;
    }
}
