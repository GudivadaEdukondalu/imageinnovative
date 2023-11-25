package org.imageinnovative.tax.calculation.controller;

import org.imageinnovative.tax.calculation.dto.Employee;
import org.imageinnovative.tax.calculation.dto.EmployeeTaxDeduction;
import org.imageinnovative.tax.calculation.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/createEmployee")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee createdEmployee = employeeService.createEmployee(employee);
        return new ResponseEntity<Employee>(createdEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {
        Employee employee = employeeService.getEmployeeById(id);
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

    @GetMapping("/tax")
    public ResponseEntity<List<EmployeeTaxDeduction>> getTaxDeductions() {
        List<EmployeeTaxDeduction> taxDeductions = employeeService.getTaxDeductions();
        return new ResponseEntity<List<EmployeeTaxDeduction>>(taxDeductions, HttpStatus.OK);
    }
}
