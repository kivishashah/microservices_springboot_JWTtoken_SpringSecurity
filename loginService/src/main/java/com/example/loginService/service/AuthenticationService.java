package com.example.loginService.service;

import com.example.loginService.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthenticationService {
    @Autowired
    private RestTemplate restTemplate;
    public String authenticateAndGetToken(String username, String password) {
        String adminServiceUrl = "http://localhost:8081/admin-service/token";
        LoginRequest loginRequest = new LoginRequest(username, password);
        String token=restTemplate.postForObject(adminServiceUrl,loginRequest, String.class);
        System.out.println(token);
        return token;
    }
}
