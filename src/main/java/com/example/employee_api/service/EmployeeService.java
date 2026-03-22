package com.example.employee_api.service;

import com.example.employee_api.dto.request.EmployeeCreateDTO;
import com.example.employee_api.model.Employee;
import com.example.employee_api.model.EmployeeFilter;

import java.util.List;

public interface EmployeeService {

    Employee create(EmployeeCreateDTO dto);

    List<Employee> getAll();

    Employee findById(Long id);

    List<Employee> findByName(String name);

    List<Employee> filter(EmployeeFilter filter);

    Employee update(Long id, Employee employee);

    void delete(Long id);
}