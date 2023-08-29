package com.giordy.giordy.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Patient")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Patient extends Base {
    @Column(name = "names", nullable = false, unique = false, length = 90)
    private String names;

    @Column(name = "surnames", nullable = false, unique = false, length = 90)
    private String surnames;

    @Column(name = "email", nullable = true, unique = false, length = 90)
    private String email;

    @Column(name = "phone", nullable = true, unique = false, length = 9)
    private String phone;

    @Column(name = "birthday", nullable = false, unique = false)
    private Date birthday;

    @Column(name = "gender", nullable = false, unique = false)
    private Boolean gender;

    @Column(name = "address", nullable = true, unique = false, length = 90)
    private String address;

    @Column(name = "hc", nullable = false, unique = true, length = 8)
    private String hc;

    @Column(name = "dni", nullable = false, unique = true, length = 8)
    private String dni;

    @ManyToOne(optional = true)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonBackReference
    private User user;

    @OneToMany(mappedBy = "patient")
    @JsonManagedReference
    private List<Appointment> appointments;
}
