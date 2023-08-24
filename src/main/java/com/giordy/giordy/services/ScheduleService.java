package com.giordy.giordy.services;

import com.giordy.giordy.entities.Schedule;
import com.giordy.giordy.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService extends BaseService<Schedule> {
    @Override
    public Schedule findById(Long id) {
        return baseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Schedule.class, id));
    }
}
