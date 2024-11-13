package com.lexmedd.backend.iam.domain.model.aggregates;

import com.lexmedd.backend.iam.domain.model.commands.SignInCommand;
import com.lexmedd.backend.iam.domain.model.commands.SignUpCommand;
import com.lexmedd.backend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Entity
@Getter
public class User extends AuditableAbstractAggregateRoot<User> {
    @NotBlank
    private String username;

    @NotBlank
    @Size(min = 4)
    private String password;

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @NotBlank
    private char gender;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 9, max = 9)
    private String phone;

    @NotBlank
    private String country;
    @NotBlank
    private String profession;

    public User() {
    }

    public User(SignUpCommand command) {
        this.username = command.username();
        this.password = command.password();
        if (command.password().length() < 4)
            throw new IllegalArgumentException("Password must be at least 4 characters long");
        this.name = command.name();
        this.surname = command.surname();

        if (command.gender() != 'M' && command.gender() != 'F')
            throw new IllegalArgumentException("Gender must be M or F");

        this.gender = command.gender();
        this.email = command.email();
        this.phone = command.phone();
        this.country = command.country();

        if (!command.profession().matches("DOCTOR") && !command.profession().matches("LAWYER"))
            throw new IllegalArgumentException("Profession must be DOCTOR or LAWYER");

        if (command.profession().matches("DOCTOR"))
            this.profession = "Doctor";
        else if (command.profession().matches("LAWYER"))
            this.profession = "Lawyer";

    }

    public User(SignInCommand command) {
        this.email = command.email();
        this.password = command.password();
    }

}
