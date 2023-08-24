package com.giordy.giordy.services;

import com.giordy.giordy.entities.Appointment;
import com.giordy.giordy.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService extends BaseService<Appointment> {
    @Override
    public Appointment findById(Long id) {
        return baseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Appointment.class, id));
    }
}
