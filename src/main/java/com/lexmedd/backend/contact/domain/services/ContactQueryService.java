package com.lexmedd.backend.contact.domain.services;

import com.lexmedd.backend.contact.domain.model.aggregates.Contact;
import com.lexmedd.backend.contact.domain.model.queries.GetAllContactByRecipientByIdQuery;
import com.lexmedd.backend.contact.domain.model.queries.GetAllContactsQuery;

import java.util.List;

public interface ContactQueryService {
    List<Contact> handle(GetAllContactsQuery query);
    List<Contact>handle(GetAllContactByRecipientByIdQuery query);
}
