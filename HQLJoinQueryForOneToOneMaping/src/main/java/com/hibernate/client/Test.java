package com.hibernate.client;

import java.util.Date;

import org.hibernate.Session;

import com.hibernate.entities.Address;
import com.hibernate.entities.Employee;
import com.hibernate.util.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		createEmployee();
	}

	public static void createEmployee() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Address address = new Address();
			address.setPostalCode("4900");
			address.setState("Dnipro");
			address.setStreet("Some street");

			Employee employee = new Employee();
			employee.setName("Java Developer");
			employee.setSalary(15000d);
			employee.setDoj(new Date());
			employee.setAddress(address);
			session.beginTransaction();
			session.save(employee);
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
