package com.clinic.clinic.controllers;

import com.clinic.clinic.DTOs.entites.ServiceHealthDTO;
import com.clinic.clinic.constants.URLs.URLResourceConstant;
import com.clinic.clinic.entities.ServiceHealth;
import com.clinic.clinic.services.ServiceHealthService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(URLResourceConstant.RESOURCE_SERVICES_HEALTH)
public class ServiceHealthController extends BaseController<ServiceHealth, ServiceHealthService, ServiceHealthDTO> {
}
