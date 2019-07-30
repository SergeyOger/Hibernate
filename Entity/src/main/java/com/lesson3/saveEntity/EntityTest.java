package com.lesson3.saveEntity;

import com.hibernate.util.HibernateUtil;
import com.lessons.entitys.Employee;

import org.hibernate.Session;

import java.util.Date;

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
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			 employeeFactory(session);
			// getEmployeeById(session);
			// updateEmployeeSalary(session, 1, 30000.0);
			// deleteEmployeeByID(session, 2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void employeeFactory(Session session) {

		session.beginTransaction();
		for (int i = 1; i <= 10; i++) {
			Employee employee = new Employee();
			employee.setEmployeeName("Employee name " + i);
			employee.setEmployeeEmail("email" + i + "@.gmail.com");
			employee.setDateOfEmploy(new Date());
			employee.setSalary(10000.00 * i);
			session.saveOrUpdate(employee);

		}
		session.getTransaction().commit();
	}

	private static void deleteEmployeeByID(Session session, int employeID) {
		Employee employee = session.get(Employee.class, employeID);
		if (employee != null) {
			session.beginTransaction();
			session.delete(employee);
			session.getTransaction().commit();
			System.out.println("Employee deleted from database");
		} else {
			System.out.println("Employee with id = " + employeID + " doesn't exist");
		}
	}

	private static void updateEmployeeSalary(Session session, int employeeId, Double salary) {
		Employee employee = session.get(Employee.class, employeeId);
		if (employee != null) {
			session.beginTransaction();
			employee.setSalary(salary);
			session.getTransaction().commit();
			System.out.println("Salary changed");
		} else {
			System.out.println("Employee with this id does not exist");
		}

	}

	private static void getEmployeeById(Session session) {
		Employee employee = session.get(Employee.class, 1);
		if (employee != null) {
			System.out.println(employee);
		} else {
			System.out.println("Employee with this id doesn't exist in database");
		}

	}

	private static void saveEmployee(Session session, Employee employee) {
		session.beginTransaction();
		Integer employeeId = (Integer) session.save(employee);
		session.getTransaction().commit();
		System.out.println("Saved employee id " + employeeId);
	}

}
