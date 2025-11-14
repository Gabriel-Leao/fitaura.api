package br.com.leao.gabriel.fitaura.api.application.user.service;

import br.com.leao.gabriel.fitaura.api.application.user.useCase.ResolveAddressCase;
import br.com.leao.gabriel.fitaura.api.application.user.useCase.UpdateUserCase;
import br.com.leao.gabriel.fitaura.api.domain.user.model.User;
import br.com.leao.gabriel.fitaura.api.domain.user.port.out.UserRepository;
import br.com.leao.gabriel.fitaura.api.shared.exceptions.ConflictException;
import br.com.leao.gabriel.fitaura.api.shared.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;


@RequiredArgsConstructor
public class UpdateUserService implements UpdateUserCase {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ResolveAddressCase resolveAddressCase;

    @Override
    public User execute(Long id, User userData) {
        var user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found"));


        userRepository.findByEmail(userData.getEmail())
                .filter(u -> !u.getId().equals(id))
                .ifPresent(u -> { throw new ConflictException("Email already taken"); });

        user.setName(userData.getName());
        user.setEmail(userData.getEmail());
        user.setBirthday(userData.getBirthday());
        user.setRole(userData.getRole());
        user.setPassword(passwordEncoder.encode(userData.getPassword()));


        if (userData.getAddress() != null && userData.getAddress().getZipCode() != null) {
            String newZipCode = userData.getAddress().getZipCode();
            String newNumber = userData.getAddress().getNumber();

            boolean shouldUpdateAddress =
                    !newZipCode.equals(user.getAddress().getZipCode()) ||
                            !newNumber.equals(user.getAddress().getNumber());

            if (shouldUpdateAddress) {
                var completedAddress = resolveAddressCase.execute(newZipCode, newNumber);
                user.setAddress(completedAddress);
            }
        }

        return userRepository.save(user);
    }
}
