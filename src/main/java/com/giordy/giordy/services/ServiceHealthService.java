package com.giordy.giordy.services;

import com.giordy.giordy.entities.ServiceHealth;
import com.giordy.giordy.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ServiceHealthService extends BaseService<ServiceHealth> {
    @Override
    public ServiceHealth findById(Long id) {
        return baseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ServiceHealth.class, id));
    }
}
