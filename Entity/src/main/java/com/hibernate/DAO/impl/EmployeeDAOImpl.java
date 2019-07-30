package com.hibernate.DAO.impl;

import org.hibernate.Session;

import com.hibernate.DAO.EmployeeDAO;
import com.hibernate.entities.Employee;
import com.hibernate.util.HibernateUtil;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public void addEmployee(Employee employee) {

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			session.beginTransaction();
			Integer id = (Integer) session.save(employee);
			System.out.println("Employee saved vith id " + id);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Employee fetchEmployeeById(int employeeId) {
		Employee employee = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			employee = session.get(Employee.class, employeeId);
			if (employee != null) {
				System.out.println("Employee exist in DB");
			} else {
				System.out.println("Employee with this id doesn't exist in database");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employee;
	}

	@Override
	public void deleteEmployeeByID(int employeID) {

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Employee employee = session.get(Employee.class, employeID);
			if (employee != null) {
				session.beginTransaction();
				session.delete(employee);
				session.getTransaction().commit();
				System.out.println("Employee deleted from database");
			} else {
				System.out.println("Employee with id = " + employeID + " doesn't exist");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateEmployeeSalaryByID(int employeeId, Double salary) {

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Employee employee = session.get(Employee.class, employeeId);
			if (employee != null) {
				session.beginTransaction();
				employee.setSalary(salary);
				session.getTransaction().commit();
			} else {
				System.out.println("Employee with this id does not exist");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
