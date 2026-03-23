package com.example.employee_api.controller;

import com.example.employee_api.dto.request.EmployeeCreateDTO;
import com.example.employee_api.model.Employee;
import com.example.employee_api.model.EmployeeFilter;
import com.example.employee_api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    @Autowired

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    // @PathVariable
    // URL: /api/employees/{id}

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.findById(id);
    }


    //  @RequestParam
    // URL: /api/employees/search?name=Tuan

    @GetMapping("/search")
    public List<Employee> searchByName(@RequestParam String name) {
        return employeeService.findByName(name);
    }

    //  @ModelAttribute
    // URL: /api/employees/filter?name=Tuan&department=IT
    @GetMapping("/filter")
    public List<Employee> filterEmployees(@ModelAttribute EmployeeFilter filter) {
        return employeeService.filter(filter);
    }
    //bai 5, them moi
    @PostMapping
    public Employee
    createEmployee(@RequestBody EmployeeCreateDTO dto){
        return employeeService.create(dto);
    }
    //update
    @PutMapping("/{id}")
    public  Employee updateEmployee(
            @PathVariable Long id,
            @RequestBody Employee employee){
        return employeeService.update(id,employee);
    }
    //delete
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id){
        employeeService.delete(id);
        return "Deleted successfully";
    }




    @GetMapping("/api/v1/employees")
    public List<Employee> getAllEmployees() {
        return List.of(
                new Employee(1L, "Nguyen Van A",null,null, 1000.0,null),
                new Employee(2L, "Tran Thi B",null,null, 1200.0,null),
                new Employee(3L, "Le Van C", null, null, 1500.0,null)
        );
    }
}

