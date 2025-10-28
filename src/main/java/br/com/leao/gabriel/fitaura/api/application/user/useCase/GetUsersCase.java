package br.com.leao.gabriel.fitaura.api.application.user.useCase;

import br.com.leao.gabriel.fitaura.api.domain.user.model.User;

import java.util.List;

public interface GetUsersCase {
    List<User> execute();
}
