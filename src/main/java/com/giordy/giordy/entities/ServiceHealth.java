package com.giordy.giordy.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "ServiceHealth")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ServiceHealth extends Base {
    @Column(name = "name", nullable = false, unique = true, length = 45)
    private String name;

    @OneToMany(mappedBy = "serviceHealth")
    @JsonManagedReference
    private List<ConsultingRoom> consultingRooms;

    @OneToMany(mappedBy = "serviceHealth")
    @JsonManagedReference
    private List<HealthPersonnel> healthPersonnels;

    @OneToMany(mappedBy = "serviceHealth")
    @JsonManagedReference
    private List<Schedule> schedules;
}
