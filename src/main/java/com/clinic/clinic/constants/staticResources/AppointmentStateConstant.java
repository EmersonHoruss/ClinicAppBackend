package com.clinic.clinic.constants.staticResources;

import com.clinic.clinic.utils.StaticResource;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public enum AppointmentStateConstant {
    PENDING("PENDING", "PENDIENTE"),
    ATTENDED("ATTENDED", "ATENDIDA"),
    RESCHEDULED("RESCHEDULED", "REPROGRAMADA");

    private @Getter String en;
    private @Getter String es;

    private AppointmentStateConstant(String en, String es) {
        this.en = en;
        this.es = es;
    }

    public static List<StaticResource> getResources(){
        List<StaticResource> staticResources = new ArrayList<>();

        for (AppointmentStateConstant role: values()) {
            staticResources.add(new StaticResource(role.en,role.es));
        }

        return staticResources;
    }
}
