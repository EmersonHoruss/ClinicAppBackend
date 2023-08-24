package com.giordy.giordy.controllers;

import com.giordy.giordy.DTOs.entites.ShiftDTO;
import com.giordy.giordy.constants.GiordyURLConstant;
import com.giordy.giordy.entities.Shift;
import com.giordy.giordy.services.ShiftService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(GiordyURLConstant.RESOURCE_SHIFTS)
public class ShiftController extends BaseController<Shift, ShiftService, ShiftDTO> {
}
