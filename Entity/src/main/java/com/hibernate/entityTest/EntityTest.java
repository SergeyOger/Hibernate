package com.hibernate.entityTest;

import java.util.Date;

import com.hibernate.entities.Employee;
import com.hibernate.model.Address;
import com.hibernate.service.EmployeeService;
import com.hibernate.service.impl.EmployeeServiceImpl;

public class EntityTest {

	/*
	 * Save entity
	 * 
	 * Save entity, will throw an exception if entity already exist in database
	 * session.persist(Object object);
	 * 
	 * Save or update entity session.saveOrUpdate(getEmployee3());
	 * 
	 * Save entity, will throw an exception if entity already exist in database.
	 * Return primary key Integer employeeId = (Integer)
	 * session.save(createEmployee());
	 */

	public static void main(String[] args) {

		EmployeeService employeeService = new EmployeeServiceImpl();
		employeeService.createEmployee(getEmployee());
		// HibernateUtil.closeSessionFactory();
//		System.out.println(employeeService.getEmployeeById(1).getEmployeeName());;
//		employeeService.updateEmployeeSalaryByID(11, 150000.00);
//		employeeService.deleteEmployeeByID(1);
	}

	private static Employee getEmployee() {

		Employee employee = new Employee();
		employee.setEmployeeName("Employee name ");
		employee.setEmployeeEmail("email@.gmail.com");
		employee.setDateOfEmploy(new Date());
		employee.setSalary(10000.00);

		Address homeAddress = new Address();
		homeAddress.setCity("Home city");
		homeAddress.setPincode(23232544421L);
		homeAddress.setState("Home state");
		homeAddress.setStreet("Home street");
		employee.setHomeAddress(homeAddress);

		Address officeAddress = new Address();
		officeAddress.setCity("Office sity");
		officeAddress.setPincode(1212121212121L);
		officeAddress.setState("Office state");
		officeAddress.setStreet("Office street");
		employee.setOfficeAddress(officeAddress);

		return employee;
	}
}
