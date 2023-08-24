package com.giordy.giordy.security;

import com.giordy.giordy.entities.User;
import com.giordy.giordy.services.UserService;
import com.giordy.giordy.utils.specification.Specification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyDatabaseUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String query = "user<eq>" + username;
        Specification specification = new Specification(query);
        Page<User> users = userService.get(specification);
        boolean existUser = users.getTotalElements() != 0;

        if(!existUser){
            throw new UsernameNotFoundException("User not found");
        }

        User user = users.getContent().get(0);

        return null;
        //org.springframework.security.core.userdetails.User
    }
}
