package br.com.leao.gabriel.fitaura.api.application.user.useCase;

import br.com.leao.gabriel.fitaura.api.domain.user.model.User;

public interface GetUserCase {
    User execute(Long id);
}
