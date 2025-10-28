package br.com.leao.gabriel.fitaura.api.domain.user.port.out;

import br.com.leao.gabriel.fitaura.api.domain.user.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User save(User user);
    Optional<User> findByEmail(String email);
    Optional<User> findById(Long id);
    List<User> findAll();
    void delete(User user);
}
