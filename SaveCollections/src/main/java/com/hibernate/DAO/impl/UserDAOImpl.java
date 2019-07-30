package com.hibernate.DAO.impl;

import org.hibernate.Session;

import com.hibernate.DAO.UserDao;
import com.hibernate.entities.User;
import com.hibernate.util.HibernateUtil;

public class UserDAOImpl implements UserDao {

    @Override
    public void createUser(User user) {
	try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	    session.beginTransaction();
	    session.persist(user);
	    session.getTransaction().commit();
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    @Override
    public User fetchUserById(int userId) {
	User user = null;
	try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	    user = session.get(User.class, userId);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return user;
    }

    @Override
    public void updateUserName(String name, int userId) {
	try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	    User user = session.get(User.class, userId);
	    if (user != null) {
		session.beginTransaction();
		user.setUserName(name);
		session.getTransaction().commit();
	    } else {
		System.out.println("USer with id " + userId + "doesn't exist");
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    @Override
    public void deleteUserById(int id) {
	try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	    User user = session.get(User.class, id);
	    if (user != null) {
		session.beginTransaction();
		session.delete(user);
		session.getTransaction().commit();
	    } else {
		System.out.println("User with id " + id + " doesn't exist");
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}

    }

}
