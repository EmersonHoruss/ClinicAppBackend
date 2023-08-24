package com.giordy.giordy.services;

import com.giordy.giordy.entities.Patient;
import com.giordy.giordy.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PatientService extends BaseService<Patient> {
    @Override
    public Patient findById(Long id) {
        return baseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Patient.class, id));
    }
}
