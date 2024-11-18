package com.lexmedd.backend.user.interfaces.rest;

import com.lexmedd.backend.shared.interfaces.rest.resources.MessageResource;
import com.lexmedd.backend.user.domain.model.aggregates.Lawyer;
import com.lexmedd.backend.user.domain.services.LawyerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/lawyers")
public class LawyerController {

    private final LawyerService lawyerService;

    public LawyerController(LawyerService lawyerService) {
        this.lawyerService = lawyerService;
    }

    @GetMapping
    public List<Lawyer> getAllLawyers() {
        return lawyerService.getAllLawyers();
    }

    @GetMapping("/{id}")
    public Optional<Lawyer> getLawyerById(@PathVariable Long id) {
        return lawyerService.getLawyerById(id);
    }

    @PostMapping
    public Lawyer createLawyer(@RequestBody Lawyer lawyer) {
        return lawyerService.saveLawyer(lawyer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lawyer> updateLawyer(@PathVariable Long id, @RequestBody Lawyer lawyer) {
        Optional<Lawyer> existingLawyer = lawyerService.getLawyerById(id);
        if (existingLawyer.isPresent()) {
            Lawyer updatedLawyer = existingLawyer.get();
            updatedLawyer.setName(lawyer.getName());
            updatedLawyer.setEmail(lawyer.getEmail());
            updatedLawyer.setPassword(lawyer.getPassword());
            updatedLawyer.setSubscription(lawyer.getSubscription());
            updatedLawyer.setYearsOfExperience(lawyer.getYearsOfExperience());
            updatedLawyer.setSpecialization(lawyer.getSpecialization());
            updatedLawyer.setCasesWon(lawyer.getCasesWon());
            updatedLawyer.setPrice(lawyer.getPrice());
            return ResponseEntity.ok(lawyerService.saveLawyer(updatedLawyer));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResource> deleteLawyer(@PathVariable Long id) {
        lawyerService.deleteLawyer(id);
        return ResponseEntity.ok(new MessageResource("Abogado eliminado con éxito"));
    }
}
