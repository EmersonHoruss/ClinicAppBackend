package com.clinic.clinic.controllers;

import com.clinic.clinic.DTOs.entites.UserDTO;
import com.clinic.clinic.constants.URLs.URLResourceConstant;
import com.clinic.clinic.entities.User;
import com.clinic.clinic.services.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(URLResourceConstant.RESOURCE_USERS)
public class UserController extends BaseController<User, UserService, UserDTO> {
}
