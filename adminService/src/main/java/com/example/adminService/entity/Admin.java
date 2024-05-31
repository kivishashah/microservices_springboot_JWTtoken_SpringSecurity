package com.example.adminService.entity;

import lombok.*;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "admin")
@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "password")
    private String password;

    @Column(name = "status")
    private Character status;

    @Column(name = "login_attempt")
    private Integer loginAttempt;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles=new ArrayList<>();

}

