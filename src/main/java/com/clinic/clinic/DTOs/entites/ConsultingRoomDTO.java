package com.clinic.clinic.DTOs.entites;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.List;

@Getter
@Setter
public class ConsultingRoomDTO extends BaseDTO {
    @NotNull
    @Max(45)
    @Min(0)
    private byte number;

    @Size(max = 90)
    private String description;

    private ServiceHealthDTO serviceHealth;

    private List<ScheduleDTO> schedules;
}
