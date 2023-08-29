package com.giordy.giordy.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

import static org.springframework.format.annotation.DateTimeFormat.*;

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
