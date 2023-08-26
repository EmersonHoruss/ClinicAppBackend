package com.giordy.giordy.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
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
    private Date start;

    @Column(name = "end", nullable = false, unique = false)
    private Date end;

    /*@OneToMany(mappedBy = "shift")
    private List<Schedule> schedules;*/
}
