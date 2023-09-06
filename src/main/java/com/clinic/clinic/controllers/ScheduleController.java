package com.clinic.clinic.controllers;

import com.clinic.clinic.DTOs.entites.ScheduleDTO;
import com.clinic.clinic.constants.URLs.URLResourceConstant;
import com.clinic.clinic.entities.Schedule;
import com.clinic.clinic.services.ScheduleService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(URLResourceConstant.RESOURCE_SCHEDULES)
public class ScheduleController extends BaseController<Schedule, ScheduleDTO> {
}
