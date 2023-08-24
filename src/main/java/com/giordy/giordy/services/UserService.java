package com.giordy.giordy.services;

import com.giordy.giordy.entities.User;
import com.giordy.giordy.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<User> {
    @Override
    public User findById(Long id) {
        return baseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(User.class, id));
    }
}
