package com.example.employee_api.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeCreateDTO {

    @NotBlank(message = "Tên không được để trống")
    private String fullName;

    @Email(message = "Email không hợp lệ")
    private String email;

    @Pattern(
            regexp = "^(03|05|07|08|09)\\d{8}$",
            message = "Số điện thoại không hợp lệ (VN)"
    )
    private String phone;

    @Min(value = 5000000, message = "Lương tối thiểu 5 triệu")
    private Double salary;

    @NotNull(message = "Phòng ban không được để trống")
    private Long departmentId;
}