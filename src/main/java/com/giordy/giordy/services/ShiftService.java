package com.giordy.giordy.services;

import com.giordy.giordy.entities.Shift;
import com.giordy.giordy.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ShiftService extends BaseService<Shift> {
    @Override
    public Shift findById(Long id) {
        return baseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Shift.class, id));
    }
}
