package com.lexmedd.backend.user.domain.services;

import com.lexmedd.backend.user.domain.model.aggregates.Lawyer;
import com.lexmedd.backend.user.infrastructure.persistence.jpa.repositories.LawyerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LawyerService {

    private final LawyerRepository lawyerRepository;

    public LawyerService(LawyerRepository lawyerRepository) {
        this.lawyerRepository = lawyerRepository;
    }

    public List<Lawyer> getAllLawyers() {
        return lawyerRepository.findAll();
    }

    public Optional<Lawyer> getLawyerById(Long id) {
        return lawyerRepository.findById(id);
    }

    public Lawyer saveLawyer(Lawyer lawyer) {
        return lawyerRepository.save(lawyer);
    }

    public void deleteLawyer(Long id) {
        lawyerRepository.deleteById(id);
    }
}