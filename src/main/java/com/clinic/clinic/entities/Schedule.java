package com.clinic.clinic.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Schedule")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Schedule extends Base {
    @Column(name = "date", nullable = false, unique = false)
    private LocalDate date;

    @Column(name = "appointments", nullable = false, unique = false)
    private short amountAppointments;

    @ManyToOne(optional = false)
    @JoinColumn(name = "health_personnel_id", referencedColumnName = "id")
    @JsonBackReference
    private HealthPersonnel healthPersonnel;

    @ManyToOne(optional = false)
    @JoinColumn(name = "shift_id", referencedColumnName = "id")
    @JsonBackReference
    private Shift shift;

    @ManyToOne(optional = false)
    @JoinColumn(name = "service_health_id", referencedColumnName = "id")
    @JsonBackReference
    private ServiceHealth serviceHealth;

    @ManyToOne(optional = false)
    @JoinColumn(name = "consulting_room_id", referencedColumnName = "id")
    @JsonBackReference
    private ConsultingRoom consultingRoom;

    @OneToMany(mappedBy = "schedule")
    @JsonManagedReference
    private List<Appointment> appointments;
}
