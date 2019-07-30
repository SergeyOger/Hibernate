package com.hibernate.service;

import com.hibernate.entities.Employee;

public interface EmployeeService {
	
	void createEmployee(Employee employee);
	
	Employee getEmployeeById(int employeeId);
	
	void updateEmployeeSalaryByID(int employeeId, Double salary);

	void deleteEmployeeByID(int employeID);
}
