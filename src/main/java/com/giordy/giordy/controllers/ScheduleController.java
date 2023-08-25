package com.giordy.giordy.controllers;

import com.giordy.giordy.DTOs.entites.ScheduleDTO;
import com.giordy.giordy.constants.URLs.URLResourceConstant;
import com.giordy.giordy.entities.Schedule;
import com.giordy.giordy.services.ScheduleService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(URLResourceConstant.RESOURCE_SCHEDULES)
public class ScheduleController extends BaseController<Schedule, ScheduleService, ScheduleDTO> {
}
