package com.giordy.giordy.DTOs.entites;

import com.giordy.giordy.entities.Patient;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
public class UserDTO extends BaseDTO {
    @Size(min = 1, max = 45)
    private String user;

    @Size(min = 1, max = 45)
    private String password;

    @Size(min = 1, max = 45)
    private String rol;

    private List<PatientDTO> patients;

    private List<HealthPersonnelDTO> healthPersonnels;
}
