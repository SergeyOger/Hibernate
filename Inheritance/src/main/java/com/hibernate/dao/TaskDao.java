package com.hibernate.dao;

import org.hibernate.Session;

import com.hibernate.dateTime.Task;
import com.hibernate.util.HibernateUtil;

public class TaskDao {

	public static void saveTask(Task task) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(task);
		session.getTransaction().commit();
		session.close();
		System.out.println("Task saved");
	}

	public static Task getTask(int taskId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Task task = session.get(Task.class, taskId);
		return task;
	}

}
