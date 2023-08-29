package com.clinic.clinic.constants.staticResources;

import com.clinic.clinic.utils.StaticResource;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public enum RoleConstant {
    RRHH("RRHH", "RRHH"),
    HEALT_PERSONNEL("HEALTH_PERSONNEL", "PERSONAL DE SALUD"),
    ADMIN("ADMIN", "ADMINISTRADOR"),
    PATIENT("PATIENT", "PACIENTE");

    private final String prefix = "ROLE_";

    private @Getter String en;
    private @Getter String es;

    private RoleConstant(String en, String es){
        this.en = en;
        this.es = es;
    }

    public static List<StaticResource> getResources(){
        List<StaticResource> staticResources = new ArrayList<>();

        for (RoleConstant role: values()) {
            staticResources.add(new StaticResource(role.en,role.es));
        }

        return staticResources;
    }

    public String roleAddedPrefix() {
        return prefix + this.name();
    }
}
