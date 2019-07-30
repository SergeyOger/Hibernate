package com.hibernate.fetchExample;

import org.hibernate.Session;

import com.hibernate.entities.Employee;
import com.hibernate.entities.Person;
import com.hibernate.entities.Student;
import com.hibernate.util.HibernateUtil;

public class FetchPersonClient {

    public static void main(String[] args) {

	try (Session session = HibernateUtil.getSessionFactory().openSession()){
	    
	    Person person = session.get(Person.class, 1);
	    if (person instanceof Student) {
		Student student = (Student)person;
		System.out.println(student.getUnivercity());
	    } else if(person instanceof Employee){
		Employee employee = (Employee)person;
		System.out.println(employee.getCompany());
	    } else {
		System.out.println(person.getName());
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

}
