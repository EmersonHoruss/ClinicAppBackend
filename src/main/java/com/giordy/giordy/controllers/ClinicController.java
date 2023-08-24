package com.giordy.giordy.controllers;

import com.giordy.giordy.DTOs.entites.ClinicDTO;
import com.giordy.giordy.constants.GiordyURLConstant;
import com.giordy.giordy.entities.Clinic;
import com.giordy.giordy.services.ClinicService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(GiordyURLConstant.RESOURCE_CLINICS)
public class ClinicController extends BaseController<Clinic, ClinicService, ClinicDTO> {
}
