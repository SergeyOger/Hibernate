package com.hibernate.test;

import com.hibernate.pojo.User;
import com.hibernate.util.HibernateUtil;
import org.hibernate.Session;

public class HibernateTest {

    public static void main(String[] args) {

        User user = new User();
        user.setId(1);
        user.setName("Some name");

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String SQL = "SELECT name FROM bird WHERE birdid = 2;";
            session.beginTransaction();
            String response = (String) session.createNativeQuery(SQL).getSingleResult();
            System.out.println("Bird name " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
