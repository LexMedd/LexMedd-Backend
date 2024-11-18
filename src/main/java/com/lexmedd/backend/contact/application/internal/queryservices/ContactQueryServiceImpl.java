package com.lexmedd.backend.contact.application.internal.queryservices;

import com.lexmedd.backend.contact.domain.model.aggregates.Contact;
import com.lexmedd.backend.contact.domain.model.queries.GetAllContactByRecipientByIdQuery;
import com.lexmedd.backend.contact.domain.model.queries.GetAllContactsQuery;
import com.lexmedd.backend.contact.domain.services.ContactQueryService;
import com.lexmedd.backend.contact.infrastructure.persistence.jpa.repositories.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactQueryServiceImpl implements ContactQueryService {

    private final ContactRepository contactRepository;

    public ContactQueryServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public List<Contact> handle(GetAllContactsQuery query) {
        return contactRepository.findAll();
    }

    @Override
    public List<Contact> handle(GetAllContactByRecipientByIdQuery query) {
        Optional<Contact> contactOptional = contactRepository.findById(query.receiverId());
        return contactOptional.map(List::of).orElseGet(List::of);
    }
}