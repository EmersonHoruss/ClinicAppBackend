package com.giordy.giordy.controllers;

import com.giordy.giordy.DTOs.entites.ConsultingRoomDTO;
import com.giordy.giordy.constants.GiordyURLConstant;
import com.giordy.giordy.entities.ConsultingRoom;
import com.giordy.giordy.services.ConsultingRoomService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(GiordyURLConstant.RESOURCE_CONSULTING_ROOMS)
public class ConsultingRoomController extends BaseController<ConsultingRoom, ConsultingRoomService, ConsultingRoomDTO> {
}
