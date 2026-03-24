package com.example.employee_api.auth;

import com.example.employee_api.dto.request.RegisterRequest;
import com.example.employee_api.security.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Public API - no need login";
    }

    @PostMapping("/login")
    public String login() {
        return "Dang nhap thanh cong";
    }

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        return authService.register(request);
    }
}