package com.lexmedd.backend.iam.repository;

import com.lexmedd.backend.iam.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
