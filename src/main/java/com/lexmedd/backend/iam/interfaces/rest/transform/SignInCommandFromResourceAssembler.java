package com.lexmedd.backend.iam.interfaces.rest.transform;

import com.lexmedd.backend.iam.domain.model.commands.SignInCommand;
import com.lexmedd.backend.iam.interfaces.rest.resources.SignInResource;

public class SignInCommandFromResourceAssembler {
    public static SignInCommand fromResource(SignInResource resource) {
        return new SignInCommand(resource.email(), resource.password());
    }

}
