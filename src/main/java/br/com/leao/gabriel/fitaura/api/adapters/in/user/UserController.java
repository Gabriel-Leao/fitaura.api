package br.com.leao.gabriel.fitaura.api.adapters.in.user;

import br.com.leao.gabriel.fitaura.api.adapters.in.user.dto.UpsertUserRequest;
import br.com.leao.gabriel.fitaura.api.adapters.in.user.dto.UserResponse;
import br.com.leao.gabriel.fitaura.api.application.user.useCase.*;
import br.com.leao.gabriel.fitaura.api.domain.user.model.User;
import br.com.leao.gabriel.fitaura.api.shared.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final DeleteUserCase deleteUserCase;
    private final CreateUserCase createUserCase;
    private final GetUserCase getUserCase;
    private final GetUsersCase getUsersCase;
    private final UpdateUserCase updateUserCase;

    @GetMapping()
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        var users = getUsersCase.execute();
        var responseUsers = users.stream().map(UserMapper::toResponse).toList();
        return ResponseEntity.ok(responseUsers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Long id) {
        var user = getUserCase.execute(id);
        return ResponseEntity.ok(UserMapper.toResponse(user));
    }

    @PostMapping()
    @Transactional
    public ResponseEntity<UserResponse> createUser(@RequestBody UpsertUserRequest userData) {
        var domainUser = UserMapper.toDomain(userData);
        User user = createUserCase.execute(domainUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(UserMapper.toResponse(user));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<UserResponse> updateUser(@PathVariable Long id, @RequestBody UpsertUserRequest userData) {
        var domainUser = UserMapper.toDomain(userData);
        User user = updateUserCase.execute(id, domainUser);
        return ResponseEntity.ok(UserMapper.toResponse(user));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        deleteUserCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}

