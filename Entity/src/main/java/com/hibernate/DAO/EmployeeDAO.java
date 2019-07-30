package com.hibernate.DAO;

import com.hibernate.entities.Employee;

public interface EmployeeDAO {

	void addEmployee(Employee employee);

	Employee fetchEmployeeById(int employeeId);

	void deleteEmployeeByID(int employeID);

	void updateEmployeeSalaryByID(int employeeId, Double salary);

}
