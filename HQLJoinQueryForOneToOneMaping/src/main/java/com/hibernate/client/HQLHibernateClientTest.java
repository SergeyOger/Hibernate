package com.hibernate.client;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.hibernate.entities.Employee;
import com.hibernate.util.HibernateUtil;

public class HQLHibernateClientTest {

	public static void main(String[] args) {
		getEmployeeNameAndAtateById(14);
	}

	public static void getEmployeeNameAndAtateById(int id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			String HQL = "SELECT emp.name, emp.salary, addr.state FROM Employee emp "
					+ "LEFT JOIN emp.address addr WHERE emp.id = :id";
			Query<Object[]> query = session.createQuery(HQL);
			query.setParameter("id", id);
			List<Object[]> list = query.list();
			for (Object[] objects : list) {
				String name = (String) objects[0];
				Double salary = (Double) objects[1];
				String state = (String) objects[2];
				System.out.println(name);
				System.out.println(salary);
				System.out.println(state);
			}
		}
	}

	public static void getEmployeeAndAddressByEmployeeId(int employeeID) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			String HQL = "FROM Employee emp LEFT JOIN FETCH emp.address WHERE emp.id = :employeeID";
			Query<Employee> query = session.createQuery(HQL, Employee.class);
			query.setParameter("employeeID", employeeID);
			Employee employee = query.getSingleResult();
			System.out.println(
					"Employee name: " + employee.getName() + " employee address: " + employee.getAddress().getState());
		}
	}

}
