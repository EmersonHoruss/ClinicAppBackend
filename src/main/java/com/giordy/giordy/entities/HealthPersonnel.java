package com.giordy.giordy.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "HealthPersonnel")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HealthPersonnel extends Base {
    @Column(name = "name", nullable = false, unique = false, length = 90)
    private String names;

    @Column(name = "surnames", nullable = false, unique = false, length = 90)
    private String surnames;

    @Column(name = "specialty", nullable = false, unique = false, length = 45)
    private String specialty;

    @Column(name = "address", nullable = false, unique = false, length = 90)
    private String address;

    @Column(name = "dni", nullable = false, unique = true, length = 8)
    private String DNI;

    @OneToOne(optional = true)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToMany(mappedBy = "healthPersonnel")
    private List<Schedule> schedules;

    @ManyToOne(optional = false)
    @JoinColumn(name = "service_health_id", referencedColumnName = "id")
    private ServiceHealth serviceHealth;
}
