package br.com.leao.gabriel.fitaura.api.adapters.out.user.persistence;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {
    @NotNull Optional<UserEntity> findByEmail(String email);

    @NotNull Optional<UserEntity> findById(long id);
}
