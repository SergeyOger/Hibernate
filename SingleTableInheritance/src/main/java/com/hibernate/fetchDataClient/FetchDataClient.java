package com.hibernate.fetchDataClient;

import org.hibernate.Session;

import com.hibernate.entities.Employee;
import com.hibernate.entities.Person;
import com.hibernate.entities.Student;
import com.hibernate.util.HibernateUtil;

public class FetchDataClient {

    public static void main(String[] args) {
	try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	    Person person = session.get(Person.class,3);
	    if(person instanceof Employee) {
		System.out.println(person + "instanceOf Employee");
	    } else if (person instanceof Student) {
		System.out.println(person + "instanceOf Student");
	    } else {
		System.out.println(person + " instanceOf Person");
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
}
