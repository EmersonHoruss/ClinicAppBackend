package com.clinic.clinic.services;

import com.clinic.clinic.entities.Patient;
import com.clinic.clinic.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PatientService extends BaseService<Patient> {
    @Override
    public Patient findById(Long id) {
        return baseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Patient.class, id));
    }
}
