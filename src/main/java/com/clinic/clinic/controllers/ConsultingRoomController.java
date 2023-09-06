package com.clinic.clinic.controllers;

import com.clinic.clinic.DTOs.entites.ConsultingRoomDTO;
import com.clinic.clinic.constants.URLs.URLResourceConstant;
import com.clinic.clinic.entities.ConsultingRoom;
import com.clinic.clinic.services.ConsultingRoomService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(URLResourceConstant.RESOURCE_CONSULTING_ROOMS)
public class ConsultingRoomController extends BaseController<ConsultingRoom, ConsultingRoomDTO> {
}
