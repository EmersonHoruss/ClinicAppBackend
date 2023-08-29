package com.clinic.clinic.DTOs.entites;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class ClinicDTO extends BaseDTO {
    @NotBlank
    @Size(min = 1, max = 45)
    private String name;

    @Size(max = 250)
    private String place;

    @Size(max = 45)
    private String category;
}
