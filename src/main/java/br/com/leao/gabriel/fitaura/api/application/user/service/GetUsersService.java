package br.com.leao.gabriel.fitaura.api.application.user.service;

import br.com.leao.gabriel.fitaura.api.application.user.useCase.GetUsersCase;
import br.com.leao.gabriel.fitaura.api.domain.user.model.User;
import br.com.leao.gabriel.fitaura.api.domain.user.port.out.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class GetUsersService implements GetUsersCase {
    private final UserRepository userRepository;

    @Override
    public List<User> execute() {
        return userRepository.findAll();
    }
}
