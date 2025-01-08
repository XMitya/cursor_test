package com.example.demo.dto;

import lombok.Data;

@Data
public class CreateUserRequest {
    private String name;
    private String surname;
    private String login;
    private String email;
    private String password;
} 