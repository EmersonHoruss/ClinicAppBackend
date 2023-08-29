package com.giordy.giordy.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @Column(name = "state", nullable = false, unique = false, length = 45)
    private String state;

    @Column(name = "sis_state", nullable = false, unique = false)
    private Boolean sisState;

    @Column(name = "order_appointment", nullable = false, unique = false)
    private byte order;

    @ManyToOne(optional = false)
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    @JsonBackReference
    private Patient patient;

    @ManyToOne(optional = false)
    @JoinColumn(name = "schedule_id", referencedColumnName = "id")
    @JsonBackReference
    private Schedule schedule;

    @OneToOne(optional = true)
    @JoinColumn(name = "appointment_id", referencedColumnName = "id")
    private Appointment rescheduledFrom;
}
