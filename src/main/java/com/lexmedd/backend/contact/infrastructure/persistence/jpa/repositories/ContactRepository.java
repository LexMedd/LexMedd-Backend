package com.lexmedd.backend.contact.infrastructure.persistence.jpa.repositories;

import com.lexmedd.backend.contact.domain.model.aggregates.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
}
