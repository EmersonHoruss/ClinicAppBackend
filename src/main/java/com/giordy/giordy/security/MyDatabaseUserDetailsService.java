package com.giordy.giordy.security;

import com.giordy.giordy.entities.User;
import com.giordy.giordy.repositories.UserRepository;
import com.giordy.giordy.services.UserService;
import com.giordy.giordy.utils.specification.Specification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class MyDatabaseUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String query = "user<eq>" + username;
        System.out.println("QUERY:" + query);
        Specification specification = new Specification(query);
        List<User> users = userService.get(specification);
        System.out.println(users);

        if(users.isEmpty()){
            throw new UsernameNotFoundException("User not found");
        }

        User userDB = users.get(0);

        if(!userDB.getUser().equals(username)) {
            throw new UsernameNotFoundException("User not found");
        }

        List<GrantedAuthority> list = new ArrayList<>();
        list.add(new SimpleGrantedAuthority(userDB.getRol()));
        return new org.springframework.security.core.userdetails.User(
                userDB.getUser(),userDB.getPassword(),list
        );
    }

    private org.springframework.security.core.userdetails.User createdUserSecurity(User userDB) {
        /*String username = userDB.getUser();
        String password = userDB.getPassword();
        boolean enabled = userDB.getActivated();
        boolean accountNonExpired = true;
        boolean credentialNonExpired = true;
        boolean credentialNonLocked = true;*/
        System.out.println("USER IN CREATED USER SECURITY:"+userDB.getUser());
        System.out.println(userDB.getUser() == "admin");
        List<GrantedAuthority> list = new ArrayList<>();
        list.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        return new org.springframework.security.core.userdetails.User(
                "admin","$2a$10$0XJN/wfeBHyJnAkURNMJNeyu5E62SIYEQH6ABd5ubvUGBFZxw1EDS",list
        );
    }
}
