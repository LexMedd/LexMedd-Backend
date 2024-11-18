package com.lexmedd.backend.iam.application.internal.commandservices;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lexmedd.backend.iam.application.internal.outboundservices.hashing.HashingService;
import com.lexmedd.backend.iam.application.internal.outboundservices.tokens.TokenService;
import com.lexmedd.backend.iam.domain.model.aggregates.User;
import com.lexmedd.backend.iam.domain.model.commands.SignInCommand;
import com.lexmedd.backend.iam.domain.model.commands.SignUpCommand;
import com.lexmedd.backend.iam.domain.services.UserCommandService;
import com.lexmedd.backend.iam.infrastructure.persistence.jpa.repositories.UserRepository;

@Service
public class UserCommandServiceImpl implements UserCommandService {
    private final UserRepository userRepository;
    private final TokenService tokenService;
    private final HashingService hashingService;

    public UserCommandServiceImpl(UserRepository userRepository, TokenService tokenService,
            HashingService hashingService) {
        this.userRepository = userRepository;
        this.tokenService = tokenService;
        this.hashingService = hashingService;
    }

    @Override
    public Optional<User> handle(SignUpCommand command) {
        var hashedCommand = new SignUpCommand(
                command.username(),
                hashingService.encode(command.password()),
                command.name(),
                command.surname(),
                command.gender(),
                command.email(),
                command.phone(),
                command.country(),
                command.profession());

        var user = new User(hashedCommand);

        if (userRepository.existsByEmail(command.email()))
            throw new IllegalArgumentException("Email already in use");

        var createdUser = userRepository.save(user);

        return Optional.of(createdUser);
    }

    @Override
    public String handle(SignInCommand command) {
        var user = userRepository.findByEmail(command.email());

        if (user.isEmpty())
            throw new IllegalArgumentException("User not found");

        if (!hashingService.matches(command.password(), user.get().getPassword()))
            throw new RuntimeException("Invalid password");

        var token = tokenService.generateToken(user.get().getEmail());
        return token;
    }

    @Override
    public Optional<User> findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

}
