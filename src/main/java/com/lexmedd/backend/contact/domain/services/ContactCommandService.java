package com.lexmedd.backend.contact.domain.services;

import com.lexmedd.backend.contact.domain.model.aggregates.Contact;
import com.lexmedd.backend.contact.domain.model.commands.CreateContactCommand;

import java.util.Optional;

public interface ContactCommandService {
    Optional<Contact> handle(CreateContactCommand command);
}
