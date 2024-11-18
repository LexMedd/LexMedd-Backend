package com.lexmedd.backend.contact.interfaces.rest.transform;

import com.lexmedd.backend.contact.domain.model.commands.CreateContactCommand;
import com.lexmedd.backend.contact.interfaces.rest.resources.CreateContactResource;

public class CreateContactFromResourceAssembler {
    public static CreateContactCommand toCommandFromResource(CreateContactResource resource) {
        return new CreateContactCommand(
                resource.type(),
                resource.consult(),
                resource.assessment(),
                resource.description(),
                resource.status(),
                resource.senderId(),
                resource.receiverId()
        );
    }

}
