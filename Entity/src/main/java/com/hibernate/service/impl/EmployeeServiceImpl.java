package com.hibernate.service.impl;

import com.hibernate.DAO.impl.EmployeeDAOImpl;
import com.hibernate.entities.Employee;
import com.hibernate.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public void createEmployee(Employee employee) {
		new EmployeeDAOImpl().addEmployee(employee);
	}

	@Override
	public Employee getEmployeeById(int employeeId) {
		return new EmployeeDAOImpl().fetchEmployeeById(employeeId);
	}

	@Override
	public void updateEmployeeSalaryByID(int employeeId, Double salary) {
		new EmployeeDAOImpl().updateEmployeeSalaryByID(employeeId, salary);
	}

	@Override
	public void deleteEmployeeByID(int employeID) {
		new EmployeeDAOImpl().deleteEmployeeByID(employeID);
	}

}
