package com.giordy.giordy.entities;

import com.giordy.giordy.services.ServiceHealthService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Schedule")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Schedule extends Base {
    @Column(name = "date", nullable = false, unique = false)
    private Date date;

    @Column(name = "appointments", nullable = false, unique = false)
    private short amount_appointments;

    @OneToMany(mappedBy = "schedule")
    private List<Appointment> appointments;

    @ManyToOne(optional = false)
    @JoinColumn(name = "health_personnel_id", referencedColumnName = "id")
    private HealthPersonnel healthPersonnel;

    @ManyToOne(optional = false)
    @JoinColumn(name = "shift_id", referencedColumnName = "id")
    private Shift shift;

    @ManyToOne(optional = false)
    @JoinColumn(name = "service_health_id", referencedColumnName = "id")
    private ServiceHealth serviceHealth;

    @ManyToOne(optional = false)
    @JoinColumn(name = "consulting_room_id", referencedColumnName = "id")
    private ConsultingRoom consultingRoom;
}
