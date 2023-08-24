package com.giordy.giordy.services;

import com.giordy.giordy.entities.Clinic;
import com.giordy.giordy.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ClinicService extends BaseService<Clinic> {
    @Override
    public Clinic findById(Long id) {
        return baseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Clinic.class, id));
    }
}
