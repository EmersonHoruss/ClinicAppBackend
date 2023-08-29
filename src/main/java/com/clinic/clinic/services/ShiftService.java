package com.clinic.clinic.services;

import com.clinic.clinic.entities.Shift;
import com.clinic.clinic.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ShiftService extends BaseService<Shift> {
    @Override
    public Shift findById(Long id) {
        return baseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Shift.class, id));
    }
}
