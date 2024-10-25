package com.lexmedd.backend.contact.interfaces.rest.resources;

public record ContactResource(
        Long id,
        String type,
        String consult,
        String assessment,
        String description,
        boolean status,
        Long senderId,
        Long receiverId
) {
}
