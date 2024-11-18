package com.lexmedd.backend.user.test;
import com.lexmedd.backend.user.domain.model.aggregates.Doctor;
import com.lexmedd.backend.user.domain.model.aggregates.Lawyer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    @Test
    public void testDoctor() {
        Doctor doctor = new Doctor();
        doctor.setId(1L);
        doctor.setName("Dr. Smith");
        doctor.setEmail("dr.smith@example.com");
        doctor.setPassword("password123");
        doctor.setSpecialization("Cardiology");
        doctor.setPlace("New York");

        assertEquals(1L, doctor.getId());
        assertEquals("Dr. Smith", doctor.getName());
        assertEquals("dr.smith@example.com", doctor.getEmail());
        assertEquals("password123", doctor.getPassword());
        assertEquals("Cardiology", doctor.getSpecialization());
        assertEquals("New York", doctor.getPlace());
    }

    @Test
    public void testLawyer() {
        Lawyer lawyer = new Lawyer();
        lawyer.setId(1L);
        lawyer.setName("John Doe");
        lawyer.setEmail("john.doe@example.com");
        lawyer.setPassword("password123");
        lawyer.setSubscription("Premium");
        lawyer.setYearsOfExperience(10);
        lawyer.setSpecialization("Corporate Law");
        lawyer.setCasesWon(50);
        lawyer.setPrice(200.0);

        assertEquals(1L, lawyer.getId());
        assertEquals("John Doe", lawyer.getName());
        assertEquals("john.doe@example.com", lawyer.getEmail());
        assertEquals("password123", lawyer.getPassword());
        assertEquals("Premium", lawyer.getSubscription());
        assertEquals(10, lawyer.getYearsOfExperience());
        assertEquals("Corporate Law", lawyer.getSpecialization());
        assertEquals(50, lawyer.getCasesWon());
        assertEquals(200.0, lawyer.getPrice());
    }
}