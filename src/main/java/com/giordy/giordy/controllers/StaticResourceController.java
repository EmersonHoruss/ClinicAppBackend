package com.giordy.giordy.controllers;

import com.giordy.giordy.DTOs.reponses.ResponseDTO;
import com.giordy.giordy.constants.URLs.URLStaticResourceConstant;
import com.giordy.giordy.constants.staticResources.AppointmentStateConstant;
import com.giordy.giordy.constants.staticResources.RoleConstant;
import com.giordy.giordy.constants.URLs.URLResourceConstant;
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

}
