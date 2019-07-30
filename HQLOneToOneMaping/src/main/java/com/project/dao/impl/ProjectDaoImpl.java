package com.project.dao.impl;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.entities.Customer;
import com.entities.Project;
import com.hibernateUtil.HibernateUtil;
import com.project.dao.ProjectDAO;

public class ProjectDaoImpl implements ProjectDAO {

	@Override
	public void saveProject(Project project) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			session.beginTransaction();
			session.persist(project);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteProjectById(long projectId) {
		Project project = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			project = session.get(Project.class, projectId);
			if (project != null) {
				session.beginTransaction();
				session.delete(project);
				session.getTransaction().commit();
			} else {
				System.out.println("Project with id = " + projectId + " doesn'n exist in database");
			}
		}
	}

	@Override
	public Project getProjectById(long projectId) {
		Project project = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			project = session.get(Project.class, projectId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return project;
	}

	@Override
	public Customer getprojectCustomerById(long projectId) {
		Customer customer = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			customer = session.get(Project.class, projectId).getCustomer();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return customer;
	}

	@Override
	public void getFullInfoAboutProjectById(int projectId) {
		String HQL = "FROM Project p LEFT FETCH p.customer WHERE p.id = :projectId";
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Query<Project> query = session.createQuery(HQL, Project.class);
			query.setParameter("projectId", projectId);
			Project project = query.getSingleResult();
			System.out.println(project.getProjectName());
			System.out.println(project.getCustomer().getCustomerName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
