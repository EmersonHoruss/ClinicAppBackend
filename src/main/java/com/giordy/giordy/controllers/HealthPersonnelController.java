package com.giordy.giordy.controllers;

import com.giordy.giordy.DTOs.entites.HealthPersonnelDTO;
import com.giordy.giordy.constants.GiordyURLConstant;
import com.giordy.giordy.entities.HealthPersonnel;
import com.giordy.giordy.services.HealthPersonnelService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(GiordyURLConstant.RESOURCE_HEALTH_PERSONNEL)
public class HealthPersonnelController extends BaseController<HealthPersonnel, HealthPersonnelService, HealthPersonnelDTO> {
}
