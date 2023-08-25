package com.giordy.giordy.controllers;

import com.giordy.giordy.DTOs.entites.ServiceHealthDTO;
import com.giordy.giordy.constants.URLs.URLResourceConstant;
import com.giordy.giordy.entities.ServiceHealth;
import com.giordy.giordy.services.ServiceHealthService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(URLResourceConstant.RESOURCE_SERVICES_HEALTH)
public class ServiceHealthController extends BaseController<ServiceHealth, ServiceHealthService, ServiceHealthDTO> {
}
