package br.com.leao.gabriel.fitaura.api.adapters.out.user.persistence;

import br.com.leao.gabriel.fitaura.api.shared.mappers.UserMapper;
import br.com.leao.gabriel.fitaura.api.domain.user.model.User;
import br.com.leao.gabriel.fitaura.api.domain.user.port.out.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private final UserJpaRepository jpaRepository;

    @Override
    public User save(User user) {
        var entity = UserMapper.toEntity(user);
        var saved = jpaRepository.save(entity);
        return UserMapper.toDomain(saved);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return jpaRepository.findByEmail(email)
                .map(UserMapper::toDomain);
    }

    @Override
    public Optional<User> findById(Long id) {
        return jpaRepository.findById(id)
                .map(UserMapper::toDomain);
    }

    @Override
    public List<User> findAll() {
        return jpaRepository.findAll().stream()
                .map(UserMapper::toDomain)
                .sorted(Comparator.comparing(User::getId))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(User user) {
        var userEntity = UserMapper.toEntity(user);
        jpaRepository.delete(userEntity);
    }
}
