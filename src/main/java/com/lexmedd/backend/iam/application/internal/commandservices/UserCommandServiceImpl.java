package com.lexmedd.backend.iam.application.internal.commandservices;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lexmedd.backend.iam.domain.model.aggregates.User;
import com.lexmedd.backend.iam.domain.model.commands.SignInCommand;
import com.lexmedd.backend.iam.domain.model.commands.SignUpCommand;
import com.lexmedd.backend.iam.domain.services.UserCommandService;
import com.lexmedd.backend.iam.infrastructure.persistence.jpa.repositories.UserRepository;

@Service
public class UserCommandServiceImpl implements UserCommandService {
    private final UserRepository userRepository;

    public UserCommandServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> handle(SignUpCommand command) {
        var user = new User(command);

        if (userRepository.existsByEmail(user.getEmail()))
            throw new IllegalArgumentException("User already exists");

        var createdUser = userRepository.save(user);

        return Optional.of(createdUser);
    }

    @Override
    public Optional<User> handle(SignInCommand command) {
        var user = userRepository.findByEmail(command.email());

        if (user.isEmpty())
            throw new IllegalArgumentException("User not found");

        if (!user.get().getPassword().equals(command.password()))
            throw new RuntimeException("Invalid password");

        return user;
    }

}
