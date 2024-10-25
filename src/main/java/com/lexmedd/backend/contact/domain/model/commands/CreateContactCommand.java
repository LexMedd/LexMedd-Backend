package com.lexmedd.backend.contact.domain.model.commands;

public record CreateContactCommand(
        String type,
        String consult,
        String assessment,
        String description,
        boolean status,
        Long senderId,
        Long receiverId
) {
}
