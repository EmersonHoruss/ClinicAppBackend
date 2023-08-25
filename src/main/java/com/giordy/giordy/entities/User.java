package com.giordy.giordy.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private List<Patient> patients;

    @OneToMany(mappedBy = "user")
    private List<HealthPersonnel> healthPersonnels;
}
