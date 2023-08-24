package com.giordy.giordy.DTOs.entites;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class ServiceHealthDTO extends BaseDTO {
    @NotBlank
    @Size(max = 45)
    private String name;
}
