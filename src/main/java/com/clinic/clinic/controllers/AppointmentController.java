package com.clinic.clinic.controllers;

import com.clinic.clinic.constants.URLs.URLResourceConstant;
import com.clinic.clinic.entities.Appointment;
import com.clinic.clinic.DTOs.entites.AppointmentDTO;
import com.clinic.clinic.services.AppointmentService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(URLResourceConstant.RESOURCE_APPOINTMENTS)
public class AppointmentController extends BaseController<Appointment, AppointmentService, AppointmentDTO> {
}
