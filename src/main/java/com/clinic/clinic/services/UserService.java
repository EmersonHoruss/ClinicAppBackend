package com.clinic.clinic.services;

import com.clinic.clinic.entities.User;
import com.clinic.clinic.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<User> {
    @Override
    public User findById(Long id) {
        return baseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(User.class, id));
    }
}
