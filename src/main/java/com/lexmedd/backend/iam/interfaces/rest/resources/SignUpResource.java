package com.lexmedd.backend.iam.interfaces.rest.resources;

public record SignUpResource(
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
