package com.clinic.clinic.controllers;

import com.clinic.clinic.DTOs.entites.PatientDTO;
import com.clinic.clinic.constants.URLs.URLResourceConstant;
import com.clinic.clinic.entities.Patient;
import com.clinic.clinic.services.PatientService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(URLResourceConstant.RESOURCE_PATIENTS)
public class PatientController extends BaseController<Patient, PatientService, PatientDTO> {
}
