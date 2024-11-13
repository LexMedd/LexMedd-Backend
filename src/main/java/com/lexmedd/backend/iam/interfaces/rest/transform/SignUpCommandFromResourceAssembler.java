package com.lexmedd.backend.iam.interfaces.rest.transform;

import com.lexmedd.backend.iam.domain.model.commands.SignUpCommand;
import com.lexmedd.backend.iam.interfaces.rest.resources.SignUpResource;

public class SignUpCommandFromResourceAssembler {
    public static SignUpCommand toCommandFromResource(SignUpResource resource) {
        return new SignUpCommand(
                resource.username(),
                resource.password(),
                resource.name(),
                resource.surname(),
                Character.toUpperCase(resource.gender()),
                resource.email(),
                resource.phone(),
                resource.country(),
                resource.profession().toUpperCase());
    }
}
