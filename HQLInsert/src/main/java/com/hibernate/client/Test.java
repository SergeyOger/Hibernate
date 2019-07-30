package com.hibernate.client;

import java.util.Date;

import org.hibernate.Session;

import com.hibernate.entities.BackupEmployee;
import com.hibernate.entities.Employee;
import com.hibernate.util.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		createBackupEmoloyee();

	}

	public static void createEmployee() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Employee employee = new Employee();
			employee.setName("Sergey Oger");
			employee.setSalary(15000.00);
			employee.setDoj(new Date());

			Employee employee1 = new Employee();
			employee1.setName("Employee 2");
			employee1.setSalary(15000.00);
			employee1.setDoj(new Date());

			session.beginTransaction();
			session.save(employee);
			session.save(employee1);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void createBackupEmoloyee() {
		BackupEmployee backupEmployee = new BackupEmployee();
		backupEmployee.setName("Second backup");
		backupEmployee.setSalary(12000D);
		backupEmployee.setDoj(new Date(System.currentTimeMillis()));

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			session.beginTransaction();
			session.save(backupEmployee);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
