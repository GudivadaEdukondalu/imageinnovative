package org.imageinnovative.tax.calculation.repository;

import java.util.List;

import org.imageinnovative.tax.calculation.dto.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository {

	Employee save(Employee employee);

	@Query(value = "select * from employee where id = ?1", nativeQuery = true)
	public Employee idbyEmpId(Long id);


	List<Employee> findAll();

	
}
