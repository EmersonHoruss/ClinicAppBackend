package com.clinic.clinic.security;

import com.clinic.clinic.entities.User;
import com.clinic.clinic.services.UserService;
import com.clinic.clinic.utils.specification.Specification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyDatabaseUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String query = "user<eq>" + username;
        Specification specification = new Specification(query);
        List<User> users = userService.get(specification);
        if(users.isEmpty()){
            throw new UsernameNotFoundException("User not found");
        }
        User userDB = users.get(0);
        if(!userDB.getUser().equals(username)) {
            throw new UsernameNotFoundException("User not found");
        }
        return getUser(userDB);
    }

    private org.springframework.security.core.userdetails.User getUser(User userDB) {
        String username = userDB.getUser();
        String password = userDB.getPassword();
        boolean enabled = userDB.getActivated();
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        List<GrantedAuthority> authorities = getAuthorities(userDB.getRole());

        return new org.springframework.security.core.userdetails.User(
                username,
                password,
                enabled,
                accountNonExpired,
                credentialsNonExpired,
                accountNonLocked,
                authorities
        );
    }

    private List<GrantedAuthority> getAuthorities(String role){
        List<GrantedAuthority> list = new ArrayList<>();
        list.add(new SimpleGrantedAuthority("ROLE_"+role));
        return list;
    }
}
