package br.com.leao.gabriel.fitaura.api.application.user.service;

import br.com.leao.gabriel.fitaura.api.application.user.useCase.DeleteUserCase;
import br.com.leao.gabriel.fitaura.api.domain.user.port.out.UserRepository;
import br.com.leao.gabriel.fitaura.api.shared.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteUserService implements DeleteUserCase {
    private final UserRepository userRepository;

    public void execute(Long id ) {
        var user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found"));
        userRepository.delete(user);
    }
}
