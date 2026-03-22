package com.example.employee_api.controller;

import com.example.employee_api.dto.request.EmployeeCreateDTO;
import com.example.employee_api.model.Employee;
import com.example.employee_api.model.EmployeeFilter;
import com.example.employee_api.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

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
}
