package com.clinic.clinic.DTOs.entites;

import com.clinic.clinic.constants.staticResources.RoleConstant;
import com.clinic.clinic.utils.StaticResource;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
public class UserDTO extends BaseDTO {
    @Size(min = 1, max = 45)
    private String user;

    @Size(min = 1, max = 60)
    private String password;

    @Size(min = 1, max = 45)
    @Pattern(regexp = "^[A-Z0-9_-]+")
    private String role;

    private List<PatientDTO> patients;

    private List<HealthPersonnelDTO> healthPersonnels;

    @AssertTrue(message = "Role not found.")
    public boolean isRoleValid() {
        List<StaticResource> roles = RoleConstant.getResources();
        for (StaticResource role :roles) {
            if(role.getEn().equals(this.role)){
                System.out.println(this.role + " - " + role.getEn());
                return true;
            }
        }
        return false;
    }
}
