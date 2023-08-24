package com.giordy.giordy.DTOs.entites;

import com.giordy.giordy.entities.Schedule;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
public class HealthPersonnelDTO extends BaseDTO {
    @NotBlank
    @Size(max = 90)
    private String names;

    @NotBlank
    @Size(max = 90)
    private String surnames;

    @NotBlank
    @Size(max = 45)
    private String specialty;

    @NotBlank
    @Size(max = 90)
    private String address;

    @NotBlank
    @Size(min = 8, max = 8)
    private String DNI;

    private UserDTO user;

    private List<ScheduleDTO> schedules;

    @NotNull
    private ServiceHealthDTO serviceHealth;
}
