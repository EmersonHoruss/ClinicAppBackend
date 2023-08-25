package com.giordy.giordy.controllers;

import com.giordy.giordy.constants.URLs.URLSecurityConstant;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class SecurityController {
    @PostMapping(URLSecurityConstant.SECURITY_SIGNUP)
    public Object signup(){
        return "signup";
    }

    @PostMapping(URLSecurityConstant.SECURITY_VALIDATE)
    public Object validate(){
        return "validate";
    }

    @PostMapping(URLSecurityConstant.SECURITY_LOGIN)
    public Object login(){
        return "login";
    }
}
