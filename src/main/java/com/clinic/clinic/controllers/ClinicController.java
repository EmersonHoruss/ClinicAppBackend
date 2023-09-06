package com.clinic.clinic.controllers;

import com.clinic.clinic.DTOs.entites.ClinicDTO;
import com.clinic.clinic.constants.URLs.URLResourceConstant;
import com.clinic.clinic.services.ClinicService;
import com.clinic.clinic.entities.Clinic;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(URLResourceConstant.RESOURCE_CLINICS)
public class ClinicController extends BaseController<Clinic, ClinicDTO> {
}
