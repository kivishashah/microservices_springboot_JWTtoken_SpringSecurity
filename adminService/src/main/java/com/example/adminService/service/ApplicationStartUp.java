package com.example.adminService.service;

import com.example.adminService.entity.Admin;

import com.example.adminService.repository.AdminRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import java.util.List;


@Component
public class ApplicationStartUp {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${com.admin.username}")
    String username;

    @Value("${com.admin.password}")
    String rawPassword;

    @Value("${com.admin.status}")
    Character status;

    @Autowired
    private AdminRepository repository;

    @Bean
    public CommandLineRunner loadData(){
        return (args) -> {
            List<Admin> admins = repository.findAll();
            boolean isTrue= ObjectUtils.isEmpty(admins);
            if(ObjectUtils.isEmpty(admins)){
                String encodedPassword = passwordEncoder.encode(rawPassword);
                this.repository.save(Admin.builder()
                        .username(username)
                        .password(encodedPassword)
                        .roles(List.of("ADMIN"))
                        .status(status)
                        .build());

            }
        };
    }


}