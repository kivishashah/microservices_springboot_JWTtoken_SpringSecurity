package com.example.loginService.controller;

import com.example.loginService.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login-service")
public class LoginServiceController {

    @Autowired
    private AuthenticationService authenticationService;

   @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam  String username, @RequestParam String password) {
            String token= authenticationService.authenticateAndGetToken(username,password);
           return ResponseEntity.ok(token);
    }

}
