package com.clinic.clinic.services;

import com.clinic.clinic.entities.User;
import com.clinic.clinic.exceptions.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService extends BaseService<User> {
    @Override
    @Transactional
    public User save(User user) {
        user.encodePassword();
        baseRepository.save(user);
        return getById(user.getId());
    }

    @Override
    @Transactional
    public User update(User user) {
        User oldUser = getById(user.getId());
        String oldPassword = oldUser.getPassword();
        if(user.hasUpdatedPassword(oldPassword)){
            user.encodePassword();
        }
        baseRepository.save(user);
        return getById(user.getId());
    }

    @Override
    public User findById(Long id) {
        return baseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(User.class, id));
    }
}
