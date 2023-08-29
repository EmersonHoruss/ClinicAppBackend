package com.clinic.clinic.services;

import com.clinic.clinic.entities.HealthPersonnel;
import com.clinic.clinic.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class HealthPersonnelService extends BaseService<HealthPersonnel> {
    @Override
    public HealthPersonnel findById(Long id) {
        return baseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(HealthPersonnel.class, id));
    }
}
