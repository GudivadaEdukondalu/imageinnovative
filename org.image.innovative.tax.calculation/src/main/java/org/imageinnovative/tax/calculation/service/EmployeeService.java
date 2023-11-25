package org.imageinnovative.tax.calculation.service;

import java.util.List;

import org.imageinnovative.tax.calculation.dto.Employee;
import org.imageinnovative.tax.calculation.dto.EmployeeTaxDeduction;


public interface EmployeeService {

	Employee createEmployee(Employee employee);

	Employee getEmployeeById(Long id);

	List<EmployeeTaxDeduction> getTaxDeductions();
	
	

}
