package com.giordy.giordy.DTOs.entites;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
public class ShiftDTO extends BaseDTO {
    @NotBlank
    @Size(max = 45)
    private String name;

    @NotNull
    private LocalTime start;

    @NotNull
    private LocalTime end;

    private List<ScheduleDTO> schedules;
}
