package com.clinic.clinic.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "User")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User extends Base {
    @Column(name = "user", nullable = false, unique = true, length = 45)
    private String user;

    @Column(name = "password", nullable = false, unique = false, length = 60)
    private String password;

    @Column(name = "rol", nullable = false, unique = false, length = 45)
    private String rol;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<Patient> patients;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<HealthPersonnel> healthPersonnels;

    public boolean hasUpdatedPassword(String oldPassword){
        return !password.equals(oldPassword);
    }

    public void encodePassword(){
        password = new BCryptPasswordEncoder().encode(password);
    }
}
