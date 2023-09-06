package com.clinic.clinic.controllers;

import com.clinic.clinic.DTOs.entites.ShiftDTO;
import com.clinic.clinic.constants.URLs.URLResourceConstant;
import com.clinic.clinic.services.ShiftService;
import com.clinic.clinic.entities.Shift;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(URLResourceConstant.RESOURCE_SHIFTS)
public class ShiftController extends BaseController<Shift, ShiftDTO> {
}
