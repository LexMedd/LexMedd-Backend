package com.lexmedd.backend.contact.interfaces.rest.transform;

import com.lexmedd.backend.contact.domain.model.aggregates.Contact;
import com.lexmedd.backend.contact.interfaces.rest.resources.ContactResource;

public class ContactResourceFromEntityAssembler {
    public static ContactResource toResourceFromEntity(Contact contact) {
        return new ContactResource(
                contact.getId(),
                contact.getType(),
                contact.getConsult(),
                contact.getAssessment(),
                contact.getDescription(),
                contact.isStatus(),
                contact.getSender().getId(),
                contact.getReceiver().getId()
        );
    }
}
