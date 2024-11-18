package com.lexmedd.backend.iam.domain.services;

import java.util.Optional;

import com.lexmedd.backend.iam.domain.model.aggregates.User;
import com.lexmedd.backend.iam.domain.model.commands.SignInCommand;
import com.lexmedd.backend.iam.domain.model.commands.SignUpCommand;

public interface UserCommandService {
    Optional<User> handle(SignUpCommand command);

    String handle(SignInCommand command);

    Optional<User> findById(Long id);
}
