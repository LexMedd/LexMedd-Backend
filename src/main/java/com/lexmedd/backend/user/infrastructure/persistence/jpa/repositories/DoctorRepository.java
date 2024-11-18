package com.lexmedd.backend.user.infrastructure.persistence.jpa.repositories;

import com.lexmedd.backend.user.domain.model.aggregates.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
