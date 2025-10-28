package br.com.leao.gabriel.fitaura.api.application.user.service;

import br.com.leao.gabriel.fitaura.api.application.user.useCase.GetUserCase;
import br.com.leao.gabriel.fitaura.api.domain.user.model.User;
import br.com.leao.gabriel.fitaura.api.domain.user.port.out.UserRepository;
import br.com.leao.gabriel.fitaura.api.shared.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class GetUserService implements GetUserCase {
    private final UserRepository userRepository;

    @Override
    public User execute(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new NotFoundException("User not found");
        }
        return user.get();
    }
}
