package com.example.employee_api.security.service;


import com.example.employee_api.dto.request.RegisterRequest;

public interface AuthService {
    String register(RegisterRequest dto);
}