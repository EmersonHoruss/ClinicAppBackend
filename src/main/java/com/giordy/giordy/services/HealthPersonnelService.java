package com.giordy.giordy.services;

import com.giordy.giordy.entities.HealthPersonnel;
import com.giordy.giordy.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class HealthPersonnelService extends BaseService<HealthPersonnel> {
    @Override
    public HealthPersonnel findById(Long id) {
        return baseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(HealthPersonnel.class, id));
    }
}
