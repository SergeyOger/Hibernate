package com.infotech.client;

import java.util.List;

import org.hibernate.Session;

import com.infotech.util.HibernateUtil;

public class HQLWithGroupByTest {

    public static void main(String[] args) {
	try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	    String HQL = "SELECT dept.departmentName, SUM(emp.salary) FROM Department dept "
		    + " LEFT JOIN dept.employees emp GROUP BY dept HAVING COUNT(emp) = 2";
	    List<Object[]> objects = session.createQuery(HQL, Object[].class).list();
	    for (Object[] objects2 : objects) {
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
