package com.clinic.clinic.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Clinic")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Clinic extends Base {
    @Column(name = "name", nullable = false, unique = false, length = 45)
    private String name;

    @Column(name = "place", nullable = true, unique = false, length = 250)
    private String place;

    @Column(name = "category", nullable = true, unique = false, length = 45)
    private String category;
}
