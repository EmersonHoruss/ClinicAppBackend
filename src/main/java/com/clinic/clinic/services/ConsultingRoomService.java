package com.clinic.clinic.services;

import com.clinic.clinic.entities.ConsultingRoom;
import com.clinic.clinic.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ConsultingRoomService extends BaseService<ConsultingRoom> {
    @Override
    public ConsultingRoom findById(Long id) {
        return baseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ConsultingRoom.class, id));
    }
}
