package com.infotech.client;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.infotech.util.HibernateUtil;

public class FetchDataClientTest {

	public static void main(String[] args) {
		getNameAndSalaryCertain(1);
	}

	public static void getNameAndSalaryCertain(int empId) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			String HQL = "SELECT emp.employeeName, emp.salary, addr.city, addr.pincode"
					+ " FROM Employee emp LEFT JOIN emp.address addr WHERE emp.employeeId =:empId";
			Query<Object[]> query = session.createQuery(HQL);
			query.setParameter("empId", empId);
			List<Object[]> employesParameters = query.list();
			for (Object[] employeeParameter : employesParameters) {
				String name = (String) employeeParameter[0];
				Double salary = (Double) employeeParameter[1];
				String city = (String) employeeParameter[2];
				Long pincode = (Long) employeeParameter[3];

				System.out.println(name + "\t" + salary + "\t" + city + "\t" + pincode);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
