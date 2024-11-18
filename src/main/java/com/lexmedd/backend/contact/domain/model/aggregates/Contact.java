package com.lexmedd.backend.contact.domain.model.aggregates;

import com.lexmedd.backend.contact.domain.model.commands.CreateContactCommand;
import com.lexmedd.backend.iam.domain.User;
import com.lexmedd.backend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Contact extends AuditableAbstractAggregateRoot<Contact> {

    @NotBlank
    private String type;

    @NotBlank
    private String consult;

    @NotBlank
    private String assessment;

    @NotBlank
    private String description;

    @NotBlank
    private boolean status = false;

    @ManyToOne
    @JoinColumn(name = "sender_id", nullable = false)
    private User sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id", nullable = false)
    private User receiver;

    public Contact() {
    }

    public Contact(CreateContactCommand command, User sender, User receiver) {
        this.type = command.type();
        this.consult = command.consult();
        this.assessment = command.assessment();
        this.description = command.description();
        this.status = command.status();
        this.sender = sender;
        this.receiver = receiver;
    }
}