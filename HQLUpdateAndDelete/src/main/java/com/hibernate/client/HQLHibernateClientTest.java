package com.hibernate.client;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.hibernate.entities.Employee;
import com.hibernate.util.HibernateUtil;

public class HQLHibernateClientTest {

	public static void main(String[] args) {
		createEmployee("Ben", new Date("11/12/2018"), 15000d);
		getAllEmployee();
	}

	public static void createEmployee(String name, Date doj, Double salary) {
		Employee employee = new Employee();
		employee.setName(name);
		employee.setDoj(doj);
		employee.setSalary(salary);
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			session.beginTransaction();
			session.save(employee);
			session.getTransaction().commit();
			System.out.println("Employee saved to database");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void deleteEmployeeById(int id) {
		String HQL = "DELETE Employee WHERE id = :id";

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Query<?> query = session.createQuery(HQL);
			query.setParameter("id", id);
			session.beginTransaction();
			int delete = query.executeUpdate();
			if (delete > 0) {
				System.out.println(delete + " records are deleted sucessful");
			} else {
				System.out.println("Something whent wrong");
			}
			session.getTransaction().commit();
		}
	}

	public static void updateEmployeeSalaryById(int id, double salary) {
		String HQL = "UPDATE Employee SET salary = :salary WHERE id = :id";

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Query<?> query = session.createQuery(HQL);
			query.setParameter("id", id);
			query.setParameter("salary", salary);

			session.beginTransaction();
			int update = query.executeUpdate();

			if (update > 0) {
				System.out.println(update + " records are updated sucessful");
			} else {
				System.out.println("Something whent wrong");
			}

			session.getTransaction().commit();
		}
	}

	public static void getAllEmployee() {
		String HQL = "FROM Employee";
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Query<Employee> query = session.createQuery(HQL, Employee.class);
			List<Employee> employees = query.getResultList();
			if (employees != null) {
				employees.forEach(
						x -> System.out.println("Employee name " + x.getName() + " Employee salary " + x.getSalary()));
			}
		}
	}

}
