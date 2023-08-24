package com.giordy.giordy.DTOs.entites;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class PatientDTO extends BaseDTO {
    @NotBlank
    @Size(max = 90)
    private String names;

    @NotBlank
    @Size(max = 90)
    private String surnames;

    @Size(max = 90)
    private String email;

    @Size(min = 9, max = 9)
    private String phone;

    @NotNull
    private Date birthday;

    @NotNull
    private Boolean gender;

    @Size(max = 90)
    private String address;

    @NotBlank
    @Size(min = 8, max = 8)
    private String hc;

    @NotBlank
    @Size(min = 8, max = 8)
    private String dni;

    private UserDTO user;

    private List<AppointmentDTO> appointments;
}
