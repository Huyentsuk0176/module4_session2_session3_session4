package com.example.employee_api.dto.request;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder

public class RegisterRequest {
    private String username;
    private String password;
    private String fullName;
}
