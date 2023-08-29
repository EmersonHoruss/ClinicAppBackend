package com.clinic.clinic.services;

import com.clinic.clinic.entities.Appointment;
import com.clinic.clinic.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService extends BaseService<Appointment> {
    @Override
    public Appointment findById(Long id) {
        return baseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Appointment.class, id));
    }
}
