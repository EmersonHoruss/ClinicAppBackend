package com.giordy.giordy.DTOs.entites;

import com.giordy.giordy.entities.Patient;
import com.giordy.giordy.entities.Schedule;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
public class AppointmentDTO extends BaseDTO {
    @NotNull
    @FutureOrPresent
    private Date date;

    @NotNull
    @Size(max = 45)
    private String status;

    @NotNull
    private Boolean sis_status;

    @NotNull
    private byte order;

    @NotNull
    private PatientDTO patient;

    @NotNull
    private ScheduleDTO schedule;

    private AppointmentDTO rescheduled_from;
}
