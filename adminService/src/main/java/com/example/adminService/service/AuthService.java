package com.example.adminService.service;


import com.example.adminService.entity.Admin;
import com.example.adminService.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

//    public String saveUser(Admin admin) {
//        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
//        adminRepository.save(admin);
//        return "user added to the system";
//    }

    public String generateToken(String username) {
        return jwtService.generateToken(username);
    }

    public void validateToken(String token) {
        jwtService.validateToken(token);
    }


}
