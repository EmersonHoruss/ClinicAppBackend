package com.giordy.giordy.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "User")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User extends Base {
    @Column(name = "user", nullable = false, unique = true, length = 45)
    private String user;

    @Column(name = "password", nullable = false, unique = false, length = 45)
    private String password;

    @Column(name = "rol", nullable = false, unique = false, length = 45)
    private String rol;

    @OneToOne(mappedBy = "user")
    private Patient patient;

    @OneToOne(mappedBy = "user")
    private HealthPersonnel healthPersonnel;
}
