package com.lexmedd.backend.contact.application.internal.commandservices;

import com.lexmedd.backend.contact.domain.model.aggregates.Contact;
import com.lexmedd.backend.contact.domain.model.commands.CreateContactCommand;
import com.lexmedd.backend.contact.domain.services.ContactCommandService;
import com.lexmedd.backend.contact.infrastructure.persistence.jpa.repositories.ContactRepository;
import com.lexmedd.backend.iam.domain.User;
import com.lexmedd.backend.iam.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContactCommandServiceImpl implements ContactCommandService {

    private final ContactRepository contactRepository;
    private final UserRepository userRepository;

    public ContactCommandServiceImpl(ContactRepository contactRepository, UserRepository userRepository) {
        this.contactRepository = contactRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Optional<Contact> handle(CreateContactCommand command) {
        Optional<User> sender = userRepository.findById(command.senderId());
        Optional<User> receiver = userRepository.findById(command.receiverId());

        if (sender.isPresent() && receiver.isPresent()) {
            Contact contact = new Contact(command, sender.get(), receiver.get());
            this.contactRepository.save(contact);
            return Optional.of(contact);
        } else {
            return Optional.empty();
        }
    }
}