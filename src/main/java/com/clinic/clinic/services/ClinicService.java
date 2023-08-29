package com.clinic.clinic.services;

import com.clinic.clinic.entities.Clinic;
import com.clinic.clinic.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ClinicService extends BaseService<Clinic> {
    @Override
    public Clinic findById(Long id) {
        return baseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Clinic.class, id));
    }
}
