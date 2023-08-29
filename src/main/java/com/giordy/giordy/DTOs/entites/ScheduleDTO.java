package com.giordy.giordy.DTOs.entites;

import com.giordy.giordy.entities.HealthPersonnel;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class ScheduleDTO extends BaseDTO {
    @NotNull
    @FutureOrPresent
    private LocalDate date;

    @NotNull
    private short amountAppointments;

    private List<AppointmentDTO> appointments;

    @NotNull
    private HealthPersonnelDTO healthPersonnel;

    @NotNull
    private ShiftDTO shift;

    @NotNull
    private ServiceHealthDTO serviceHealth;

    @NotNull
    private ConsultingRoomDTO consultingRoom;
}
