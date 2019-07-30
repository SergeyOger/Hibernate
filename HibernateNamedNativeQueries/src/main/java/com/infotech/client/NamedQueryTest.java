package com.infotech.client;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.type.IntegerType;

import com.infotech.entities.Employee;
import com.infotech.util.HibernateUtil;

public class NamedQueryTest {

	public static void main(String[] args) {
		getTotalDepartmentSalary();
//		getEmployeeByID(1);
	}

	public static void getEmployeeByID(int employeeId) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Query<Employee> getEmployee = session.createNamedQuery("getEmployeeById");
			getEmployee.setParameter("empId", employeeId);
			Employee employee = getEmployee.getSingleResult();
			System.out.println(employee);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void getTotalDepartmentSalary() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Query<Object[]> query = session.createNamedQuery("getTotalSalaryOfEmployeesByDept");
			List<Object[]> list = query.list();
			for (Object[] objects2 : list) {
				String departmentName = (String) objects2[0];
				Double salary = (Double) objects2[1];
				System.out.println("Department name " + departmentName);
				System.out.println("Total salary by department " + salary);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}