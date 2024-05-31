package com.example.adminService.controller;

import com.example.adminService.dto.LoginRequest;
import com.example.adminService.entity.Admin;
import com.example.adminService.repository.AdminRepository;
import com.example.adminService.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/admin-service")
public class AdminController {

    @Autowired
    private AuthService service;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AdminRepository adminRepository;

    @GetMapping("/hello")
    public String hello(){
        return "hello world!!";
    }

    @PostMapping("/token")
    public String getToken(@RequestBody LoginRequest loginRequest) {
        String username= loginRequest.getUsername();
        String password = loginRequest.getPassword();

        Optional<Admin> admin=adminRepository.findByUsername(username);

        if(admin.isPresent() && admin.get().getPassword().equals(password)){
            return service.generateToken(username);
        }else{
            throw new RuntimeException("invalid access");
        }
    }

    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token) {
        service.validateToken(token);
        return "Token is valid";
    }
}
