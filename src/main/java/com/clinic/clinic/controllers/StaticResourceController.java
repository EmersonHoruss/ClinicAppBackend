package com.clinic.clinic.controllers;

import com.clinic.clinic.DTOs.reponses.ResponseDTO;
import com.clinic.clinic.constants.URLs.URLStaticResourceConstant;
import com.clinic.clinic.constants.staticResources.AppointmentStateConstant;
import com.clinic.clinic.constants.staticResources.RoleConstant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class StaticResourceController {

    @GetMapping(URLStaticResourceConstant.RESOURCE_ROLES)
    public ResponseEntity<ResponseDTO> getRoles() {
        ResponseDTO responseDTO = new ResponseDTO(RoleConstant.getResources());
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }

    @GetMapping(URLStaticResourceConstant.RESOURCE_APPOINTMENT_STATES)
    public ResponseEntity<ResponseDTO> getAppointmentStates() {
        ResponseDTO responseDTO = new ResponseDTO(AppointmentStateConstant.getResources());
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }

    @GetMapping(URLStaticResourceConstant.RESOURCE_SPECIALTIES)
    public ResponseEntity<ResponseDTO> getSpecialties() {
        ResponseDTO responseDTO = new ResponseDTO(AppointmentStateConstant.getResources());
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }
}
