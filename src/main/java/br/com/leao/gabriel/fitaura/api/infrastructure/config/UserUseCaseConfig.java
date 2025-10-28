package br.com.leao.gabriel.fitaura.api.infrastructure.config;

import br.com.leao.gabriel.fitaura.api.application.user.service.*;
import br.com.leao.gabriel.fitaura.api.application.user.useCase.*;
import br.com.leao.gabriel.fitaura.api.domain.user.port.out.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserUseCaseConfig {
    @Bean
    public GetUsersCase getUsersCase(UserRepository userRepository) {
        return new GetUsersService(userRepository);
    }

    @Bean
    public GetUserCase getUserCase(UserRepository userRepository) {
        return new GetUserService(userRepository);
    }

    @Bean
    public DeleteUserCase deleteUserCase(UserRepository userRepository) {
        return new DeleteUserService(userRepository);
    }

    @Bean
    public CreateUserCase createUserCase(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return new CreateUserService(userRepository, passwordEncoder);
    }

    @Bean
    public UpdateUserCase updateUserCase(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return new UpdateUserService(userRepository, passwordEncoder);
    }
}

