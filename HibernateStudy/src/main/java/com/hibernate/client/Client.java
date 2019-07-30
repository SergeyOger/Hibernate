package com.hibernate.client;

import org.hibernate.Session;

import com.hibernate.util.HibernateUtil;

public class Client {

	public static void main(String[] args) {

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			String SQL = "SELECT name FROM bird WHERE birdid = 2;";
			String result = (String) session.createNativeQuery(SQL).getSingleResult();
			System.out.println("Bird name is " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
