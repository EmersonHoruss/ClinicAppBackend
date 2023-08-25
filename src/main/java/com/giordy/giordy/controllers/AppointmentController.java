package com.giordy.giordy.controllers;

import com.giordy.giordy.DTOs.entites.AppointmentDTO;
import com.giordy.giordy.constants.URLs.URLResourceConstant;
import com.giordy.giordy.entities.Appointment;
import com.giordy.giordy.services.AppointmentService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(URLResourceConstant.RESOURCE_APPOINTMENTS)
public class AppointmentController extends BaseController<Appointment, AppointmentService, AppointmentDTO> {
}
