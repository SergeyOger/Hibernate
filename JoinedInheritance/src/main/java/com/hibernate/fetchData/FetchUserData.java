package com.hibernate.fetchData;

import org.hibernate.Session;

import com.hibernate.entities.Person;
import com.hibernate.util.HibernateUtil;

public class FetchUserData {

    public static void main(String[] args) {

	try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	    Person person = session.get(Person.class, 3);
	    System.out.println(person.getClass());
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

}
