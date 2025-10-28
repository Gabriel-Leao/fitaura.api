package br.com.leao.gabriel.fitaura.api.application.user.service;

import br.com.leao.gabriel.fitaura.api.application.user.useCase.CreateUserCase;
import br.com.leao.gabriel.fitaura.api.domain.user.model.User;
import br.com.leao.gabriel.fitaura.api.domain.user.port.out.UserRepository;
import br.com.leao.gabriel.fitaura.api.shared.exceptions.ConflictException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@RequiredArgsConstructor
public class CreateUserService implements CreateUserCase {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User execute(User user) {
        Optional<User> optionalUser = userRepository.findByEmail(user.getEmail());
        if (optionalUser.isPresent()) {
            throw new ConflictException("User with email " + user.getEmail() + " already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
