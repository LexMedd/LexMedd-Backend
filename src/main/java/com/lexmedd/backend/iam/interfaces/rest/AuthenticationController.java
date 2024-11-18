package com.lexmedd.backend.iam.interfaces.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lexmedd.backend.iam.domain.services.UserCommandService;
import com.lexmedd.backend.iam.interfaces.rest.resources.AuthenticatedUserResource;
import com.lexmedd.backend.iam.interfaces.rest.resources.SignInResource;
import com.lexmedd.backend.iam.interfaces.rest.resources.SignUpResource;
import com.lexmedd.backend.iam.interfaces.rest.resources.UserResource;
import com.lexmedd.backend.iam.interfaces.rest.transform.SignInCommandFromResourceAssembler;
import com.lexmedd.backend.iam.interfaces.rest.transform.SignUpCommandFromResourceAssembler;
import com.lexmedd.backend.iam.interfaces.rest.transform.UserResourceFromEntityAssembler;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/api/v1/authentication", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Authentication", description = "Authentication Endpoints")

public class AuthenticationController {
    private final UserCommandService userCommandService;

    public AuthenticationController(UserCommandService userCommandService) {
        this.userCommandService = userCommandService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResource> signUp(@RequestBody SignUpResource resource) {
        var signUpCommand = SignUpCommandFromResourceAssembler.toCommandFromResource(resource);
        var user = userCommandService.handle(signUpCommand);
        if (user.isEmpty())
            return ResponseEntity.badRequest().build();

        var userResource = UserResourceFromEntityAssembler.toResourceFromEntity(user.get());

        return new ResponseEntity<>(userResource, HttpStatus.CREATED);

    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticatedUserResource> signIn(@RequestBody SignInResource resource) {
        var SignInCommand = SignInCommandFromResourceAssembler.fromResource(resource);

        var token = userCommandService.handle(SignInCommand);

        if (token.isEmpty())
            return ResponseEntity.badRequest().build();

        var authenticatedUserResource = new AuthenticatedUserResource(token);

        return new ResponseEntity<>(authenticatedUserResource, HttpStatus.OK);

    }
}
