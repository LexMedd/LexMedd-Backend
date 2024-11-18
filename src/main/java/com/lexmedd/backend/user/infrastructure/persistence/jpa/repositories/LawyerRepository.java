package com.lexmedd.backend.user.infrastructure.persistence.jpa.repositories;

import com.lexmedd.backend.user.domain.model.aggregates.Lawyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LawyerRepository extends JpaRepository<Lawyer, Long> {
}
