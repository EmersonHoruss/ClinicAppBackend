package com.giordy.giordy.controllers;

import com.giordy.giordy.DTOs.entites.UserDTO;
import com.giordy.giordy.constants.URLs.URLResourceConstant;
import com.giordy.giordy.entities.User;
import com.giordy.giordy.services.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(URLResourceConstant.RESOURCE_USERS)
public class UserController extends BaseController<User, UserService, UserDTO> {
}
