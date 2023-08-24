package com.giordy.giordy.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.Date;

@Entity
@Table(name = "Appointment")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Appointment extends Base {
    @Column(name = "date", nullable = false, unique = false)
    private Date date;

    @Column(name = "status", nullable = false, unique = false, length = 45)
    private String status;

    @Column(name = "sis_status", nullable = false, unique = false)
    private Boolean sis_status;

    @Column(name = "order", nullable = false, unique = false)
    private byte order;

    @ManyToOne(optional = false)
    private Patient patient;

    @ManyToOne(optional = false)
    private Schedule schedule;

    @OneToOne(optional = true)
    @JoinColumn(name = "appointment_id", referencedColumnName = "id")
    private Appointment rescheduled_from;
}
