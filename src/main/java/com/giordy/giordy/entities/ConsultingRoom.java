package com.giordy.giordy.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ConsultingRoom")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConsultingRoom extends Base {
    @Column(name = "number", nullable = false, unique = true, length = 45)
    private byte number;

    @Column(name = "description", nullable = true, unique = false, length = 90)
    private String description;

    /*@OneToMany(mappedBy = "consultingRoom")
    private List<Schedule> schedules;*/

    @ManyToOne(optional = true)
    @JoinColumn(name = "service_health_id", referencedColumnName = "id")
    private ServiceHealth serviceHealth;
}
