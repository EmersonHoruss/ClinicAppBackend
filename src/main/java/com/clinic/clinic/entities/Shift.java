package com.clinic.clinic.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "Shift")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Shift extends Base {
    @Column(name = "name", nullable = false, unique = true, length = 45)
    private String name;

    @Column(name = "start", nullable = false, unique = false)
    private LocalTime start;

    @Column(name = "end", nullable = false, unique = false)
    private LocalTime end;

    @OneToMany(mappedBy = "shift")
    @JsonManagedReference
    private List<Schedule> schedules;
}
