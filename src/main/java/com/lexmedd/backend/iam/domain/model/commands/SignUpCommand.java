package com.lexmedd.backend.iam.domain.model.commands;

public record SignUpCommand(
                String username,
                String password,
                String name,
                String surname,
                char gender,
                String email,
                String phone,
                String country,
                String profession) {

}
