package br.com.leao.gabriel.fitaura.api.domain.user.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
public class User {
    private Long id;
    private String name;
    private String email;
    private String password;
    private LocalDate birthday;
    private Role role;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public void setBirthday(LocalDate birthday) {
        if (birthday.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Data de nascimento não pode ser no futuro");
        }
        this.birthday = birthday;
    }

    public void setRole(Role role) {
        this.role = Objects.requireNonNullElse(role, Role.USER);
    }
}
