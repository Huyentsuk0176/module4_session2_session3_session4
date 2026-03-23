package com.example.employee_api.service;

import com.example.employee_api.dto.request.EmployeeCreateDTO;
import com.example.employee_api.model.Employee;
import com.example.employee_api.model.EmployeeFilter;
import com.example.employee_api.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final List<Employee> employees = new ArrayList<>();
    private Long idCounter = 1L;

    // ✅ CREATE
    //@Override
    public Employee create(EmployeeCreateDTO dto) {
        Employee emp = new Employee();

    emp.setId(idCounter++);
        emp.setFullName(dto.getFullName());
        emp.setEmail(dto.getEmail());
        emp.setPhone(dto.getPhone());
        emp.setSalary(dto.getSalary());
        emp.setDepartmentId(dto.getDepartmentId());

        employees.add(emp);
        return emp;
    }

    // ✅ GET ALL
    @Override
    public List<Employee> getAll() {
        return employees;
    }

    // ✅ FIND BY ID
    @Override
    public Employee findById(Long id) {
        return employees.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // ✅ FIND BY NAME
    @Override
    public List<Employee> findByName(String name) {
        return employees.stream()
                .filter(e -> e.getFullName().toLowerCase().contains(name.toLowerCase()))
                .toList();
    }

    // ✅ FILTER (tạm basic)
    @Override
    public List<Employee> filter(EmployeeFilter filter) {
        return employees.stream()
                .filter(e -> filter.getName() == null || e.getFullName().contains(filter.getName()))
                .filter(e -> filter.getDepartmentId() == null || e.getDepartmentId().equals(filter.getDepartmentId()))
                .toList();
    }

    // ✅ UPDATE
    @Override
    public Employee update(Long id, Employee employee) {
        Employee existing = employees.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (existing != null) {
            existing.setFullName(employee.getFullName());
            existing.setEmail(employee.getEmail());
            existing.setPhone(employee.getPhone());
            existing.setSalary(employee.getSalary());
            existing.setDepartmentId(employee.getDepartmentId());
        }

        return existing;
    }

    // ✅ DELETE
    @Override
    public void delete(Long id) {
        employees.removeIf(e -> e.getId().equals(id));
    }
}