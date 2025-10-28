package br.com.leao.gabriel.fitaura.api.application.user.service;

import br.com.leao.gabriel.fitaura.api.application.user.useCase.UpdateUserCase;
import br.com.leao.gabriel.fitaura.api.domain.user.model.User;
import br.com.leao.gabriel.fitaura.api.domain.user.port.out.UserRepository;
import br.com.leao.gabriel.fitaura.api.shared.exceptions.ConflictException;
import br.com.leao.gabriel.fitaura.api.shared.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@RequiredArgsConstructor
public class UpdateUserService implements UpdateUserCase {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User execute(Long id, User userData) {
        Optional<User> optionalUser = userRepository.findById(id);
        if ( optionalUser.isEmpty()) {
            throw new NotFoundException("User not found");
        }
        User user = optionalUser.get();
        var isEmailAlreadyTaken = userRepository.findByEmail(userData.getEmail()).isPresent();
        if (isEmailAlreadyTaken) {
            throw new ConflictException("Email already taken");
        }
        user.setPassword(passwordEncoder.encode(userData.getPassword()));
        user.setName(userData.getName());
        user.setBirthday(userData.getBirthday());
        user.setRole(userData.getRole());
        user.setEmail(userData.getEmail());
        return userRepository.save(user);
    }
}
