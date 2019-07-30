package com.hibernate.client;

import org.hibernate.Session;

import com.hibernate.entities.Employee;
import com.hibernate.entities.Person;
import com.hibernate.entities.Student;
import com.hibernate.util.HibernateUtil;

public class Test {

    public static void main(String[] args) {
	try(Session session = HibernateUtil.getSessionFactory().openSession()) {
	    Person person = new Person();
	    person.setName("Jon");
	    person.setAge(25);
	    
	    Employee  employee = new Employee();
	    employee.setName("Sergey");
	    employee.setAge(26);
	    employee.setSalary(15000.32);
	    employee.setCompany("IBM");
	    
	    Student student = new Student();
	    student.setName("Student");
	    student.setAge(30);
	    student.setUnivercity("UCTU");
	    
	    session.beginTransaction();
	    session.save(person);
	    session.save(employee);
	    session.save(student);
	    session.getTransaction().commit();
	    
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	
	
    }

}
