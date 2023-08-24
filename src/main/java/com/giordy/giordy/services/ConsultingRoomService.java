package com.giordy.giordy.services;

import com.giordy.giordy.entities.ConsultingRoom;
import com.giordy.giordy.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ConsultingRoomService extends BaseService<ConsultingRoom> {
    @Override
    public ConsultingRoom findById(Long id) {
        return baseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ConsultingRoom.class, id));
    }
}
