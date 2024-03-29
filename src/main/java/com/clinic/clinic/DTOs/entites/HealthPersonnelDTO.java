package com.clinic.clinic.DTOs.entites;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@ToString
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

    @Size(min = 8, max = 8)
    private String dni;

    private UserDTO user;

    private ServiceHealthDTO serviceHealth;

    private List<ScheduleDTO> schedules;
}
