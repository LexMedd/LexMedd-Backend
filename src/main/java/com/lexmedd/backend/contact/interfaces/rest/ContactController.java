package com.lexmedd.backend.contact.interfaces.rest;

import com.lexmedd.backend.contact.domain.model.queries.GetAllContactByRecipientByIdQuery;
import com.lexmedd.backend.contact.domain.model.queries.GetAllContactsQuery;
import com.lexmedd.backend.contact.domain.services.ContactCommandService;
import com.lexmedd.backend.contact.domain.services.ContactQueryService;
import com.lexmedd.backend.contact.interfaces.rest.resources.ContactResource;
import com.lexmedd.backend.contact.interfaces.rest.resources.CreateContactResource;
import com.lexmedd.backend.contact.interfaces.rest.transform.ContactResourceFromEntityAssembler;
import com.lexmedd.backend.contact.interfaces.rest.transform.CreateContactFromResourceAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/contact")
@Tag(name = "Contact", description = "Contact API")
public class ContactController {
    private final ContactQueryService contactQueryService;
    private final ContactCommandService contactCommandService;

    public ContactController(ContactQueryService contactQueryService, ContactCommandService contactCommandService) {
        this.contactQueryService = contactQueryService;
        this.contactCommandService = contactCommandService;
    }

    @GetMapping
    public ResponseEntity<List<ContactResource>> getAllContacts() {
        var getAllContactsQuery = new GetAllContactsQuery();
        var contacts = contactQueryService.handle(getAllContactsQuery);
        var contactResources = contacts.stream().map(ContactResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(contactResources);
    }

    @GetMapping("/receiver/{receiverId}")
    public ResponseEntity<List<ContactResource>> getAllContactsByRecipientId(@PathVariable Long receiverId) {
        var getAllContactByRecipientByIdQuery = new GetAllContactByRecipientByIdQuery(receiverId);
        var contacts = contactQueryService.handle(getAllContactByRecipientByIdQuery);
        var contactResources = contacts.stream().map(ContactResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(contactResources);
    }

    @PostMapping
    public ResponseEntity<ContactResource> createContact(@RequestBody CreateContactResource resource) {
        var createContactCommand = CreateContactFromResourceAssembler.toCommandFromResource(resource);
        var contact = contactCommandService.handle(createContactCommand);
        if (contact.isEmpty())
            return ResponseEntity.badRequest().build();
        var contactResource = ContactResourceFromEntityAssembler.toResourceFromEntity(contact.get());
        return new ResponseEntity<>(contactResource, org.springframework.http.HttpStatus.CREATED);

    }
}
