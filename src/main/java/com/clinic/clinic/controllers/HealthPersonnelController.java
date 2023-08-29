package com.clinic.clinic.controllers;

import com.clinic.clinic.DTOs.entites.HealthPersonnelDTO;
import com.clinic.clinic.constants.URLs.URLResourceConstant;
import com.clinic.clinic.entities.HealthPersonnel;
import com.clinic.clinic.services.HealthPersonnelService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(URLResourceConstant.RESOURCE_HEALTH_PERSONNEL)
public class HealthPersonnelController extends BaseController<HealthPersonnel, HealthPersonnelService, HealthPersonnelDTO> {
}
