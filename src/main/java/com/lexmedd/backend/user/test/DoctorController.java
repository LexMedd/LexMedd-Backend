package com.lexmedd.backend.user.test;

import com.lexmedd.backend.shared.interfaces.rest.resources.MessageResource;
import com.lexmedd.backend.user.domain.model.Doctor;
import com.lexmedd.backend.user.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @GetMapping("/{id}")
    public Optional<Doctor> getDoctorById(@PathVariable Long id) {
        return doctorService.getDoctorById(id);
    }

    @PostMapping
    public Doctor createDoctor(@RequestBody Doctor doctor) {
        return doctorService.saveDoctor(doctor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable Long id, @RequestBody Doctor doctor) {
        Optional<Doctor> existingDoctor = doctorService.getDoctorById(id);
        if (existingDoctor.isPresent()) {
            Doctor updatedDoctor = existingDoctor.get();
            updatedDoctor.setName(doctor.getName());
            updatedDoctor.setEmail(doctor.getEmail());
            updatedDoctor.setPassword(doctor.getPassword());
            updatedDoctor.setSpecialization(doctor.getSpecialization());
            updatedDoctor.setPlace(doctor.getPlace());
            return ResponseEntity.ok(doctorService.saveDoctor(updatedDoctor));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResource> deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
        return ResponseEntity.ok(new MessageResource("Doctor eliminado con éxito"));
    }
}
