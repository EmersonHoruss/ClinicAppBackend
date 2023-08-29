package com.clinic.clinic.services;

import com.clinic.clinic.entities.Schedule;
import com.clinic.clinic.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService extends BaseService<Schedule> {
    @Override
    public Schedule findById(Long id) {
        return baseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Schedule.class, id));
    }
}
