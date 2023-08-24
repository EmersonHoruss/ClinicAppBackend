package com.giordy.giordy.controllers;

import com.giordy.giordy.DTOs.entites.PatientDTO;
import com.giordy.giordy.constants.GiordyURLConstant;
import com.giordy.giordy.entities.Patient;
import com.giordy.giordy.services.PatientService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(GiordyURLConstant.RESOURCE_PATIENTS)
public class PatientController extends BaseController<Patient, PatientService, PatientDTO> {
}
