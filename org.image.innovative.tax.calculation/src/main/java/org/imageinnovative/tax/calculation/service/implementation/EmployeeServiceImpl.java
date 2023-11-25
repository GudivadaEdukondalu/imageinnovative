package org.imageinnovative.tax.calculation.service.implementation;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.imageinnovative.tax.calculation.dto.Employee;
import org.imageinnovative.tax.calculation.dto.EmployeeTaxDeduction;
import org.imageinnovative.tax.calculation.repository.EmployeeRepository;
import org.imageinnovative.tax.calculation.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeRepository employeerepo;
	

	public Employee createEmployee(Employee employee) {
			employeerepo.save(employee);
		return employee;
	}

	public Employee getEmployeeById(Long id) {
		Employee emp= employeerepo.idbyEmpId(id);
		return emp;
	}

	public List<EmployeeTaxDeduction> getTaxDeductions() {
		List<Employee> employees = employeerepo.findAll();
        LocalDate today = LocalDate.now();
        int financialYearStart = today.getMonthValue() >= 4 ? today.getYear() : today.getYear() - 1;
        int financialYearEnd = financialYearStart + 1;
        return employees.stream()
                .map(employee -> {
                    long yearlySalary = employee.getSalary() * 12;
                    long taxAmount = 0;
                    if (yearlySalary > 2500000) {
                        taxAmount = 2500000 * 10 / 100 + (yearlySalary - 2500000) * 20 / 100;
                    } else if (yearlySalary > 1000000) {
                        taxAmount = 1000000 * 10 / 100 + (yearlySalary - 1000000) * 20 / 100;
                    } else if (yearlySalary > 500000) {
                        taxAmount = 500000 * 10 / 100 + (yearlySalary - 500000) * 10 / 100;
                    } else if (yearlySalary > 250000) {
                        taxAmount = 250000 * 10 / 100;
                    }
                    long cessAmount = taxAmount * 2 / 100;
                    return new EmployeeTaxDeduction(employee.getEmployeeId(), employee.getFirstName(), employee.getLastName(), yearlySalary, taxAmount, cessAmount);
                })
                .collect(Collectors.toList());
    }
	

}
