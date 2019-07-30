package com.hibernate.client;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.hibernate.entities.Employee;
import com.hibernate.util.HibernateUtil;

public class HQLHibernateClientTest {

    public static void main(String[] args) {
//	getEmployeeByIdAndName(1, "Sergey Oger");
//	getEmployeeNames();
	getEmployeeIdAndName();
    }

    public static void getAllEmployee() {
	try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	    String HQL = "FROM Employee";
	    Query<Employee> query = session.createQuery(HQL, Employee.class);
	    List<Employee> employees = query.list();
	    employees.forEach(x -> System.out.println(x.getName()));
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    public static void getEmployeeById(int employeeID) {
	try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	    String HQL = "FROM Employee WHERE id = ?0";
	    Query<Employee> query = session.createQuery(HQL, Employee.class);
	    query.setParameter(0, employeeID);
	    Employee employee = query.uniqueResult();
	    System.out.println(employee.getName());
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    public static void getEmployeeByIdAndName(int id, String name) {
	try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	    String HQL = "FROM Employee WHERE id = :id AND name = :name";
	    Query<Employee> query = session.createQuery(HQL, Employee.class);
	    query.setParameter("id", id);
	    query.setParameter("name", name);
	    Employee employee = query.uniqueResult();
	    System.out.println(employee.getName() + employee.getSalary());
	} catch (Exception e) {
	    e.printStackTrace();
	}

    }

    public static void getEmployeeNames() {
	try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	    String HQL = "SELECT name FROM Employee";
	    Query<String> query = session.createQuery(HQL);
	    query.getResultList().forEach(System.out::println);
	} catch (Exception e) {
	    e.printStackTrace();
	}

    }

    public static <T> void getEmployeeIdAndName() {
	try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	    String HQL = "SELECT id,name FROM Employee";
	    Query query = session.createQuery(HQL);
	    List<Object[]> list = query.list();
	    list.forEach(x -> System.out.println(x[0] + "\t" + x[1]));
	    // another way
	    for (Object[] objects : list) {
		Integer integer = (Integer) objects[0];
		String string = (String) objects[1];
		System.out.println(integer + " " + string);
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}

    }

}
