package com.example.employee_api.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 1. Không tìm thấy sinh viên
    @ExceptionHandler(StudentNotFoundException.class)
    public Map<String, Object> handleStudentNotFound(StudentNotFoundException ex) {

        Map<String, Object> error = new HashMap<>();

        error.put("status", 404);
        error.put("message", "Sinh viên không tồn tại");
        error.put("timestamp", LocalDateTime.now());

        return error;
    }

    // 2. Chia cho 0
    @ExceptionHandler(ArithmeticException.class)
    public Map<String, Object> handleArithmeticException(ArithmeticException ex) {

        Map<String, Object> error = new HashMap<>();

        error.put("status", 400);
        error.put("message", "Không thể chia cho 0");
        error.put("timestamp", LocalDateTime.now());

        return error;
    }

    // 3. Nhập chữ thay vì số
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public Map<String, Object> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {

        Map<String, Object> error = new HashMap<>();

        error.put("status", 400);
        error.put("message", "Dữ liệu nhập vào phải là số");
        error.put("timestamp", LocalDateTime.now());

        return error;
    }

    // 4. Lỗi hệ thống
    @ExceptionHandler(Exception.class)
    public Map<String, Object> handleException(Exception ex) {

        Map<String, Object> error = new HashMap<>();

        error.put("status", 500);
        error.put("message", "Lỗi hệ thống");
        error.put("timestamp", LocalDateTime.now());

        return error;
    }
}