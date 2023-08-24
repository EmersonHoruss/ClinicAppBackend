package com.giordy.giordy.DTOs.entites;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;

@Getter
@Setter
public class UserDTO extends BaseDTO {
    @Size(min = 1, max = 45)
    private String user;

    @Size(min = 1, max = 45)
    private String password;

    @Size(min = 1, max = 45)
    private String rol;
}
