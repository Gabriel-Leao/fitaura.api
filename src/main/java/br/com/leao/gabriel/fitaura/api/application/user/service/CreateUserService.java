package br.com.leao.gabriel.fitaura.api.application.user.service;

import br.com.leao.gabriel.fitaura.api.application.user.useCase.CreateUserCase;
import br.com.leao.gabriel.fitaura.api.application.user.useCase.ResolveAddressCase;
import br.com.leao.gabriel.fitaura.api.domain.user.model.User;
import br.com.leao.gabriel.fitaura.api.domain.user.port.out.UserRepository;
import br.com.leao.gabriel.fitaura.api.shared.exceptions.ConflictException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;


@RequiredArgsConstructor
public class CreateUserService implements CreateUserCase {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ResolveAddressCase resolveAddressCase;

    @Override
    public User execute(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new ConflictException("User with email " + user.getEmail() + " already exists");
        }


        var completedAddress = resolveAddressCase.execute(
                user.getAddress().getZipCode(),
                user.getAddress().getNumber()
        );

        var finalUser = User.builder()
                .name(user.getName())
                .email(user.getEmail())
                .birthday(user.getBirthday())
                .role(user.getRole())
                .password(passwordEncoder.encode(user.getPassword()))
                .address(completedAddress)
                .build();

        return userRepository.save(finalUser);
    }
}
