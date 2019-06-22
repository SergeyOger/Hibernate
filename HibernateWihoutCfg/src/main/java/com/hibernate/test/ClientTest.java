package com.hibernate.test;

import com.hibernate.util.HibernateUtil;
import org.hibernate.Session;

public class ClientTest {

    public static void main(String[] args) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            String request = "SELECT name FROM bird WHERE birdid = 2;";
            String response = (String) session.createNativeQuery(request).getSingleResult();
            System.out.println("BIrd name " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
